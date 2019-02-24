package com.stackroute.listener;

import com.stackroute.domain.AnalysisResult;
import com.stackroute.domain.Paragraph;
import com.stackroute.service.AnalyticService;
import com.stackroute.service.ParagraphProviderService;
import com.stackroute.service.ParagraphService;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaConsumer {
    private ParagraphService paragraphService;
    private KafkaProducer kafkaProducer;
    private ParagraphProviderService paragraphProviderService;

    @Autowired
    public KafkaConsumer(ParagraphProviderService paragraphProviderService, ParagraphService paragraphService, KafkaProducer kafkaProducer) {
        this.paragraphService = paragraphService;
        this.kafkaProducer = kafkaProducer;
        this.paragraphProviderService = paragraphProviderService;
    }
//    @Autowired
//    private KafkaTemplate<String, Paragraph> kafkaTemplate;

    //  private static final String TOPIC = "Kafka_Example2";
    @KafkaListener(topics = "ParagraphContents", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);

        JSONObject object = (JSONObject) JSONValue.parse(message);

        Paragraph paragraph = new Paragraph(object.get("paragraphId").toString(), object.get("paragraphText").toString(), object.get("documentId").toString());
        System.out.println("aaaaaaaaaaaaaaaa"+paragraph.getDocumentId());
        System.out.println("bbbbbbbbbbbbbbbbb"+paragraph.getParagraphId());
        System.out.println("cccccccccccccccccc"+paragraph.getParagraphContent());
        paragraphService.takeParagraph(paragraph);
        paragraphProviderService.setParagraph(paragraph);
        kafkaProducer.postservice();
    }
}