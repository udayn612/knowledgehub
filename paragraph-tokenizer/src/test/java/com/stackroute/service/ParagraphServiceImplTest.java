///*
//This is the service test class.
// */
//
//package com.stackroute.service;
//
//import com.stackroute.exception.ParagraphNotFoundException;
//import org.json.simple.JSONObject;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//public class ParagraphServiceImplTest {
//
//    private ParagraphServiceImpl para;
//
//    @Before
//    public void setUp() throws Exception {
//        this.para = new ParagraphServiceImpl();
//    }
//
//    @Test
//    public void testGetParagraphObject(){
//        List<JSONObject> list = new ArrayList();
//        JSONObject obj = new JSONObject();
//        JSONObject obj3 = new JSONObject();
//        obj3.put("documentId","23233");
//        list.add(obj3);
//        JSONObject document = new JSONObject();
//        document.put("documentId", "23233");
//        document.put("documentText","Hi my name is blah.\nI live in blah and i like to blah.\nhi again!\n");
//        document.put("documentMetadata","metadata");
//        obj.put("paragraphId", 1);
//        obj.put("paragraphText", "Hi my name is blah.");
//        list.add(obj);
//        JSONObject obj1 = new JSONObject();
//        obj1.put("paragraphId", 2);
//        obj1.put("paragraphText", "I live in blah and i like to blah.");
//        list.add(obj1);
//        JSONObject obj2 = new JSONObject();
//        obj2.put("paragraphId", 3);
//        obj2.put("paragraphText", "hi again!");
//        list.add(obj2);
//        try {
//            assertEquals(this.para.getParagraphObject(document),list);
//        } catch (ParagraphNotFoundException e) {
//            e.printStackTrace();
//        }
//
//    }
//}