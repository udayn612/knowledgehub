package com.stackroute.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.domain.AnalysisResult;
import com.stackroute.domain.Paragraph;
import com.stackroute.service.AnalyticService;
import com.stackroute.service.ParagraphProviderService;
import com.stackroute.service.ParagraphService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class AnalyticServiceControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private Paragraph paragraph;

    private AnalysisResult analysisResult;

    @MockBean
    private ParagraphService paragraphService;

    @MockBean
    private AnalyticService analyticService;

    @MockBean
    private ParagraphProviderService paragraphProviderService;


    @InjectMocks
    private AnalyticServiceController analyticServiceController;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(analyticServiceController).build();
        paragraph = new Paragraph();
        paragraph.setDocumentId("D001");
        paragraph.setParagraphId("P001");
        paragraph.setParagraphContent("what is spring framework");
        analysisResult = new AnalysisResult();
        analysisResult.setConcept("spring framework");
        analysisResult.setConfidenceScore(25.5);
        analysisResult.setDocumentId("D001");
        analysisResult.setParagraphId("P001");
        analysisResult.setDomain("spring framework");
        analysisResult.setIntentLevel("knowledge");
        analysisResult.setParagraphContent("what is spring framework");
    }

    @Test
    public void setParagraph() throws Exception {
        when(paragraphService.takeParagraph(any())).thenReturn(paragraph);
        mockMvc.perform(MockMvcRequestBuilders.post("/paragraph")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(paragraph)))
                .andExpect(MockMvcResultMatchers.content().string("Paragraph is successfully taken."))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getAnalysisResult() throws Exception {
        when(analyticService.getAnalysisResult()).thenReturn(analysisResult);
        mockMvc.perform(MockMvcRequestBuilders.get("/analysisResult")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(analysisResult)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}