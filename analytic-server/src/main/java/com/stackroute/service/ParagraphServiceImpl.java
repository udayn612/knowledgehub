package com.stackroute.service;

import com.stackroute.domain.NlpResult;
import com.stackroute.domain.Paragraph;
import com.stackroute.nlpService.NlpService;
import com.stackroute.nlpService.NlpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ParagraphServiceImpl implements ParagraphService {
    private Paragraph paragraph;
    private NlpService nlpService;
    private ConceptSerive conceptSerive;
    private AnalyticService analyticService;
    private NlpResultService nlpResultService;

    @Autowired
    public ParagraphServiceImpl(NlpService nlpService, ConceptSerive conceptSerive, AnalyticService analyticService, NlpResultService nlpResultService) {
        this.nlpService = nlpService;
        this.conceptSerive = conceptSerive;
        this.analyticService = analyticService;
        this.nlpResultService = nlpResultService;
    }

    public Paragraph getParagraph() {
        return paragraph;
    }

    public void setParagraph(Paragraph paragraph) {
        this.paragraph = paragraph;
    }

    public Paragraph takeParagraph(Paragraph paragraph) {
        this.paragraph = paragraph;
        nlpService.setParagraphContent(paragraph.getParagraphContent());
        ArrayList<String> conceptNames = (ArrayList<String>) (conceptSerive.getConcepts());
        String[] conceptNamesArray = new String[conceptNames.size()];
        for (int i = 0; i < conceptNames.size(); i++) {
            conceptNamesArray[i] = conceptNames.get(i).toLowerCase();
        }
        nlpService.setConceptNames(conceptNamesArray);
        NlpResult nlpResult = nlpService.getNlpResults();
        nlpResultService.setNlpResult(nlpResult);
        analyticService.setConceptNames(conceptNamesArray);
        return paragraph;
    }
}
