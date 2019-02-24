package com.stackroute.listener;

import com.stackroute.domain.Paragraph;
import com.stackroute.domain.PdfDocument;
import com.stackroute.exception.ParagraphNotFoundException;
import com.stackroute.service.ParagraphService;
import com.stackroute.listener.KafkaProducer;
import netscape.javascript.JSObject;
import org.apache.kafka.common.protocol.types.Field;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class KafkaConsumer {

    private ParagraphService paragraphService;
    private KafkaProducer kafkaProducer;

    @Autowired
    public KafkaConsumer(ParagraphService paragraphService,KafkaProducer kafkaProducer) {
        this.kafkaProducer=kafkaProducer;
        this.paragraphService = paragraphService;
    }







//    @Autowired
//    private KafkaTemplate<String, JSObject> kafkaTemplate;
//
//    private static final String TOPIC = "FileText";

    @KafkaListener(topics = "FileText", groupId = "group_id")
    public void consume(String message) throws ParagraphNotFoundException {

        JSONObject object=(JSONObject) JSONValue.parse(message);
        PdfDocument pdfDocument=new PdfDocument(object.get("documentId").toString(),object.get("documentText").toString(),
                (JSONObject) object.get("documentMetaData"));
        System.out.println(message);

        List<JSONObject> paragraphList=paragraphService.getParagraphObject(pdfDocument.getDocumentId(),pdfDocument.getDocumentText());

        kafkaProducer.postservice(paragraphList);

        System.out.println("text\n"+pdfDocument.getDocumentText());
        System.out.println("Id\n"+pdfDocument.getDocumentId());
        System.out.println("metadata\n"+pdfDocument.getDocumentMetaData());
    }
}

