package com.stackroute.listener;

import com.stackroute.domain.FileUrl;
import com.stackroute.domain.PdfDocument;
import com.stackroute.exception.EmptyFileException;
import com.stackroute.exception.FileNotFoundException;
import com.stackroute.service.PdfExtractionService;
import org.apache.tika.exception.TikaException;
import org.springframework.stereotype.Service;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.xml.sax.SAXException;

import java.io.IOException;


@Service
public class KafkaConsumer {



    private PdfExtractionService pdfExtractionService;
    private KafkaProducer kafkaProducer;

    @Autowired
    public KafkaConsumer( PdfExtractionService pdfExtractionService, KafkaProducer kafkaProducer) {
        this.pdfExtractionService = pdfExtractionService;
        this.kafkaProducer = kafkaProducer;
    }
//    @Autowired
//    private KafkaTemplate<String, Paragraph> kafkaTemplate;

    //  private static final String TOPIC = "Kafka_Example2";
    @KafkaListener(topics = "FileUrl", groupId = "group_id")
    public void consume(String message)throws IOException, SAXException, NullPointerException, FileNotFoundException, EmptyFileException,
            TikaException {
        System.out.println("Consumed message: " + message);

      JSONObject object = (JSONObject) JSONValue.parse(message);


      FileUrl fileUrl=new FileUrl(object.get("fileUrl").toString());
        System.out.println(fileUrl.getFileUrl());


//        PdfDocument pdfDocument=new PdfDocument(object.get("documentId").toString(),
//                object.get("documentText").toString(),(JSONObject)(object.get("documentMetaData")));
//        System.out.println("#########################");
//        System.out.println(pdfDocument.getDocumentId());
//        System.out.println(pdfDocument.getDocumentText());
//        System.out.println(pdfDocument.getDocumentMetaData());
//        System.out.println("**************************");
//
//        pdfDocument.setDocumentId(pdfDocument.getDocumentId());
//        pdfDocument.setDocumentText(pdfDocument.getDocumentText());
//        pdfDocument.setDocumentMetaData(pdfDocument.getDocumentMetaData());
      kafkaProducer.postservice(fileUrl.getFileUrl());


//        Paragraph paragraph = new Paragraph(object.get("paragraphId").toString(), object.get("paragraphText").toString(), object.get("documentId").toString());
//        System.out.println(paragraph.getDocumentId());
//        System.out.println(paragraph.getParagraphId());
//        System.out.println(paragraph.getParagraphContent());
//        pdfExtractionService.takeParagraph(paragraph);
//        paragraphProviderService.setParagraph(paragraph);
//        kafkaProducer.postservice();
    }





}
