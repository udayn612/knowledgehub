package com.stackroute.service;

import com.stackroute.domain.AnalysisResult;
import com.stackroute.domain.NlpResult;
import com.stackroute.domain.Paragraph;
import com.stackroute.nlpService.NlpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AnalyticServiceImpl implements AnalyticService {
    private String conceptNames[];
    private NlpResultService nlpResultService;
    private ParagraphProviderService paragraphProviderService;


    @Autowired
    public AnalyticServiceImpl(NlpResultService nlpResultService,ParagraphProviderService paragraphProviderService) {
        this.nlpResultService = nlpResultService;
        this.paragraphProviderService = paragraphProviderService;
    }

    public String getNounSentence() {
        NlpResult nlpResult = nlpResultService.getNlpResult();
        StringBuilder nounSentence = new StringBuilder();
        ArrayList<String> nouns = new ArrayList<>(nlpResult.getNounWords());
        for (int i = 0; i < nouns.size(); i++) {
            nounSentence.append(nouns.get(i) + " ");
        }
        return nounSentence.toString().trim().toLowerCase();
    }

    public String getConceptName() {
        int conceptNameCount[] = new int[conceptNames.length];
        int max = 0;
        int conceptIndex = -1;
        for (int i = 0; i < conceptNames.length; i++) {
            String pattenString = conceptNames[i];
            Pattern pattern = Pattern.compile(pattenString);
            Matcher matcher = pattern.matcher(getNounSentence());
            while (matcher.find()) {
                conceptNameCount[i]++;
            }
        }
        for (int i = 0; i < conceptNameCount.length; i++) {
            if (conceptNameCount[i] > max) {
                max = conceptNameCount[i];
                conceptIndex = i;
            }
        }
        if (conceptIndex == -1) {
            return "No Concept is found for this paragraph";
        } else {
            return conceptNames[conceptIndex];
        }
    }

    public String getVerbSentence() {
        StringBuilder verbSentence = new StringBuilder();
        ArrayList<String> verbs = new ArrayList<>(nlpResultService.getNlpResult().getVerbWords());
        for (int i = 0; i < verbs.size(); i++) {
            verbSentence.append(verbs.get(i) + " ");
        }
        return verbSentence.toString().trim().toLowerCase();
    }

    public double getConfidenceScore(){
        return 25.5;
    }

    public String getIntentLevel(){
        return "knowledge";
    }

    public AnalysisResult getAnalysisResult() {
        AnalysisResult analysisResult = new AnalysisResult();
        System.out.println("Analytic Service Result in Analytic Service Impl .java");
        analysisResult.setConfidenceScore(getConfidenceScore());
        analysisResult.setDocumentId(paragraphProviderService.getParagraph().getDocumentId());
        analysisResult.setParagraphId(paragraphProviderService.getParagraph().getParagraphId());
        analysisResult.setDomain("spring framework");
        analysisResult.setIntentLevel(getIntentLevel());
        analysisResult.setConcept(getConceptName());
        analysisResult.setParagraphContent(nlpResultService.getNlpResult().getClearedParagraph());
        return analysisResult;
    }

    public String[] getConceptNames() {
        return conceptNames;
    }

    public void setConceptNames(String[] conceptNames) {
        this.conceptNames = conceptNames;
    }
}