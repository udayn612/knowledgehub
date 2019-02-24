package com.stackroute.listener;

import com.stackroute.domain.PdfDocument;
import com.stackroute.exception.EmptyFileException;
import com.stackroute.exception.FileNotFoundException;
import com.stackroute.service.PdfExtractionService;
import org.apache.tika.exception.TikaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.xml.sax.SAXException;

import java.io.IOException;

public class KafkaProducer {

    private PdfExtractionService pdfExtractionService;

    @Autowired
    public KafkaProducer(PdfExtractionService pdfExtractionService) {
        this.pdfExtractionService = pdfExtractionService;
    }

    @Autowired
    private KafkaTemplate<String, PdfDocument> kafkaTemplate2;

    private static final String TOPIC="FileText";
    public String postservice() throws IOException, SAXException, NullPointerException, FileNotFoundException, EmptyFileException,
            TikaException
    {

        PdfDocument pdfDocument = pdfExtractionService.extractFromURL();
        kafkaTemplate2.send(TOPIC, pdfDocument);


        return "Published successfully";
    }

}
