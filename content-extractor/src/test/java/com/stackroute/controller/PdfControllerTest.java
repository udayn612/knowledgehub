//package com.stackroute.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.service.PdfExtractionService;
//import org.junit.After;
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
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.when;
//
//public class PdfControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    public PdfExtractionService pdfExtractionService;
//
//    @InjectMocks
//    private PdfController pdfController;
//
//    @Before
//    public void setUp()
//    {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(pdfController).build();
//        pdfExtractionService= org.mockito.Mockito.mock(PdfExtractionService.class);
//
//    }
//
//    @After
//    public void turnDown()
//    {
//        pdfExtractionService= null;
//    }
//
//    @Test
//    public void getDocument() throws Exception
//    {
//        when(pdfExtractionService.extractFromFile(anyString())).thenReturn(anyString());
//        mockMvc.perform(MockMvcRequestBuilders.get("/result")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(anyString())))
//                .andExpect(MockMvcResultMatchers.status().isNotFound())
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
//
//}
