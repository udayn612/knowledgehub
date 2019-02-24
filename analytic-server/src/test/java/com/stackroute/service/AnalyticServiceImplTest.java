package com.stackroute.service;

import com.stackroute.domain.Concept;
import com.stackroute.domain.NlpResult;
import com.stackroute.repository.ConceptRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AnalyticServiceImplTest {

    private ArrayList<String> nouns;
    private ArrayList<String> verbs;
    NlpResult nlpResult;

    @Mock
    private NlpResultService nlpResultService;

    @Mock
    private ParagraphProviderService paragraphProviderService;

    @InjectMocks
    private AnalyticServiceImpl analyticServiceImpl;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        nouns = new ArrayList<>();
        nouns.add("spring");
        nouns.add("framework");
        verbs = new ArrayList<>();
        verbs.add("define");
        nlpResult = new NlpResult();
        nlpResult.setNounWords(nouns);
        nlpResult.setVerbWords(verbs);
    }

    @Test
    public void getNounSentence() {
        when(nlpResultService.getNlpResult()).thenReturn(nlpResult);
        StringBuilder expected = new StringBuilder();
        for (int i = 0; i < nouns.size(); i++) {
            expected.append(nouns.get(i) + " ");
        }
        String expectedString = expected.toString().trim();

        String actualString = analyticServiceImpl.getNounSentence();

        System.out.println(expectedString);
        System.out.println(actualString);
        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void getConceptName() {
    }

    @Test
    public void getVerbSentence() {
        when(nlpResultService.getNlpResult()).thenReturn(nlpResult);
        StringBuilder expected = new StringBuilder();
        for (int i = 0; i < verbs.size(); i++) {
            expected.append(verbs.get(i) + " ");
        }
        String expectedString = expected.toString().trim();

        String actualString = analyticServiceImpl.getVerbSentence();

        System.out.println(expectedString);
        System.out.println(actualString);
        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void getConfidenceScore() {
    }

    @Test
    public void getIntentLevel() {
    }

    @Test
    public void getAnalysisResult() {
    }

    @Test
    public void getConceptNames() {
    }

    @Test
    public void setConceptNames() {
    }
}