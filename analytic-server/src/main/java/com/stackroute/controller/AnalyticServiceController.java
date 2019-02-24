package com.stackroute.controller;

import com.stackroute.domain.AnalysisResult;
import com.stackroute.domain.Concept;
import com.stackroute.service.AnalyticService;
import com.stackroute.service.ConceptSerive;
import com.stackroute.domain.Paragraph;
import com.stackroute.service.ParagraphProviderService;
import com.stackroute.service.ParagraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/")
public class AnalyticServiceController {
    private ParagraphService paragraphService;
    private AnalyticService analyticService;
    private ParagraphProviderService paragraphProviderService;

    @Autowired
    public AnalyticServiceController(ParagraphProviderService paragraphProviderService,ParagraphService paragraphService, AnalyticService analyticService) {
        this.paragraphService = paragraphService;
        this.analyticService = analyticService;
        this.paragraphProviderService = paragraphProviderService;
    }

    @PostMapping("paragraph")
    public ResponseEntity<?> setParagraph(@RequestBody Paragraph paragraph) {
        ResponseEntity responseEntity;
        try {
            paragraphService.takeParagraph(paragraph);
            paragraphProviderService.setParagraph(paragraph);
            responseEntity = new ResponseEntity<String>("Paragraph is successfully taken.", HttpStatus.OK);
            return responseEntity;
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>("Paragraph is not taken.", HttpStatus.BAD_REQUEST);
            return responseEntity;
        }
    }

    @GetMapping("analysisResult")
    public ResponseEntity<AnalysisResult> getAnalysisResult() {
        ResponseEntity responseEntity;
        try {

            AnalysisResult analysisResult;
            analysisResult = analyticService.getAnalysisResult();
            return new ResponseEntity<AnalysisResult>(analysisResult,HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<String>("No results found.", HttpStatus.BAD_REQUEST);
            return responseEntity;
        }
    }
}
