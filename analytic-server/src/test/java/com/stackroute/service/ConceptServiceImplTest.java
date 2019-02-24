package com.stackroute.service;

import com.stackroute.domain.Concept;
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
import static org.mockito.Mockito.when;

public class ConceptServiceImplTest {

    Concept concept;
    List<Concept> conceptNames;
    @Mock
    private ConceptRepository conceptRepository;

    @InjectMocks
    private ConceptServiceImpl conceptServiceImpl;

    /*
    <id>:1
    classType: concept
    context: Spring framework
    identity: SPRING:2
    name: Spring Core
    parent_id: SPRING:1
    relation: subconcept of
    type: concept
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        concept = new Concept();
        concept.setClassType("conept");
        concept.setId(1);
        concept.setName("spring framework");
        concept.setContext("Spring framework");
        concept.setName("Spring Core");
        concept.setParent_id("SPRING:1");
        concept.setRelation("subconcept of");
        concept.setType("concept");
        concept.setClassType("concept");
        conceptNames = new ArrayList<>();
        conceptNames.add(concept);
    }

    @Test
    public void getConcepts() {
        conceptRepository.save(concept);
        when(conceptRepository.getAllConcepts()).thenReturn(conceptNames);
        List<String> expected = new ArrayList<>();
        for (int i = 0; i < conceptNames.size(); i++) {
            expected.add(conceptNames.get(i).getName());
        }
        List<String> actual = conceptServiceImpl.getConcepts();
        Assert.assertEquals(actual, expected);
    }
}