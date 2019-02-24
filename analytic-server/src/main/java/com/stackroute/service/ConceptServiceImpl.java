package com.stackroute.service;

import com.stackroute.domain.Concept;
import com.stackroute.repository.ConceptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
public class ConceptServiceImpl implements ConceptSerive {
    private ConceptRepository conceptRepository;

    public ConceptServiceImpl(ConceptRepository conceptRepository) {
        this.conceptRepository = conceptRepository;
    }

    public List<String> getConcepts() {
        ArrayList<Concept> concepts = new ArrayList<>(conceptRepository.getAllConcepts());
        ArrayList<String> conceptNames = new ArrayList<>();
        for (int i = 0; i < concepts.size(); i++) {
            conceptNames.add(concepts.get(i).getName());
        }
        return conceptNames;
    }
}