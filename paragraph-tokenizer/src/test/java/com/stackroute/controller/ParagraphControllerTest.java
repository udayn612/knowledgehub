///*
//This is the controller test class.
// */
//
//package com.stackroute.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.domain.Paragraph;
//import com.stackroute.exception.ParagraphNotFoundException;
//import com.stackroute.service.ParagraphService;
//import org.json.simple.JSONObject;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import static org.junit.Assert.*;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest
//public class ParagraphControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private ParagraphService paragraphService;
//
//    @InjectMocks
//    private ParagraphController paragraphController;
//
//    private List<JSONObject> objects =null;
//
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(paragraphController).build();
//        objects = new ArrayList<>();
//        JSONObject obj= new JSONObject();
//        obj.put("documentId","23233");
//        objects.add(obj);
//        JSONObject obj1= new JSONObject();
//        obj1.put("paragraphId", 1);
//        obj1.put("paragraphText", "Hi my name is blah.");
//        objects.add(obj1);
//        JSONObject obj2 = new JSONObject();
//        obj2.put("paragraphId", 2);
//        obj2.put("paragraphText", "I live in blah and i like to blah.");
//        objects.add(obj2);
//        JSONObject obj3 = new JSONObject();
//        obj3.put("paragraphId", 3);
//        obj3.put("paragraphText", "hi again!");
//        objects.add(obj3);
//    }
//
//    @Test
//    public void testGetAllJSONObjects() throws Exception {
//        when(paragraphService.getParagraphObject(any())).thenReturn("Published successfully");
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/paragraphs")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(objects)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//
//    }
//
//    @Test
//    public void testGetAllJSONObjectsFailure() throws Exception {
//        when(paragraphService.getParagraphObject(any())).thenThrow(ParagraphNotFoundException.class);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/paragraphs")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(objects)))
//                .andExpect(MockMvcResultMatchers.status().isConflict())
//                .andDo(MockMvcResultHandlers.print());
//
//    }
//
//    private static String asJsonString(final Object obj)
//    {
//        try{
//            return new ObjectMapper().writeValueAsString(obj);
//
//        }catch(Exception e){
//            throw new RuntimeException(e);
//        }
//    }
//}
//
