package com.stackroute.listener;

import com.stackroute.model.Knowledge;
import com.stackroute.service.KnowledgeIndexerService;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {


    private KnowledgeIndexerService knowledgeIndexerService;

    @Autowired
    public KafkaConsumer(KnowledgeIndexerService knowledgeIndexerService) {
        this.knowledgeIndexerService = knowledgeIndexerService;
    }

    @KafkaListener(topics = "AnalyticsResults", groupId = "group_id")
    public void consume(String message)
    {
        System.out.println("Consumed message: " + message);
        JSONObject object = (JSONObject) JSONValue.parse(message);
        Knowledge knowledge=new Knowledge(object.get("paragraphId").toString(),object.get("paragraphContent").toString(),
                object.get("documentId").toString(),object.get("domain").toString()
                ,object.get("concept").toString(),object.get("intentLevel").toString(),Double.parseDouble(object.get("confidenceScore").toString()));


//        private String paragraphId;
//        private String paragraphContent;  //paragraphContent(given as name to identify in neo4j database easily)
//        private String documentId;
//        private String domain;
//        private String concept;
//        private String intentLevel;
//        private double confidenceScore;



        System.out.println("Concept"+knowledge.getConcept());
        System.out.println("Confidence"+knowledge.getConfidenceScore());
        System.out.println("DocumentId"+knowledge.getDocumentId());
        System.out.println("IntentLevel"+knowledge.getIntentLevel());
        System.out.println("Domain"+knowledge.getDomain());
        System.out.println("Name"+knowledge.getName());
        System.out.println("ParagraphId"+knowledge.getParagraphId());


        knowledgeIndexerService.saveKnowledgeToDb(knowledge);
        knowledgeIndexerService.addRelationship(knowledge.getConcept(),knowledge.getParagraphId(),knowledge.getIntentLevel(),knowledge.getConfidenceScore());


    }


}
