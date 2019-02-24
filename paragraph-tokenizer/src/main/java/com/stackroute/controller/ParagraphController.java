/*
This is the controller class that takes request and gives the appropriate response entity.
 */

package com.stackroute.controller;

import com.stackroute.domain.Paragraph;
import com.stackroute.exception.ParagraphNotFoundException;
import com.stackroute.service.ParagraphService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/v1")
public class ParagraphController {
    private ParagraphService paragraphService;

    JSONObject objects = new JSONObject();

    @Autowired
    public ParagraphController(ParagraphService paragraphService){
        this.paragraphService = paragraphService;
    }

    @PostMapping("paragraph")
    public ResponseEntity<?> postJSONObject(@RequestBody JSONObject document){
        ResponseEntity responseEntity;
        try{
            this.objects=document;
            responseEntity = new ResponseEntity<String>("Successfully posted", HttpStatus.ACCEPTED);
        }
        catch (Exception ex){
            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
//
//    @GetMapping("paragraphs/{documentId}")
//    public ResponseEntity<?> getAllJSONObjects(){
//        ResponseEntity responseEntity;
//        try {
//            responseEntity= new ResponseEntity<String>(paragraphService.getParagraphObject(), HttpStatus.OK);
//        } catch (ParagraphNotFoundException ex) {
//            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
//        }
//        return responseEntity;
//    }

}
