package com.stackroute.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.stackroute.exception.EmptyFileException;
import com.stackroute.exception.FileNotFoundException;
import com.stackroute.domain.PdfDocument;

import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;


import java.io.*;
import java.net.URL;
import java.util.UUID;

@Service
@PropertySource(value = "classpath:application.properties")
public class PdfExtractionServiceImpl implements PdfExtractionService {

    @Value("${fileNotFound}")
    private String fileNotFound;

    @Value("${EmptyFile}")
    private String EmptyFile;


    String path;

    /*kafka consumer*/
//    @KafkaListener(topics = "File_url", groupId = "group_id")
//    public void consume(String message) {
//
//        System.out.println("under consume");
//        JSONObject object = (JSONObject) JSONValue.parse(message);
//        path = (String) object.get("fileUrl");
//        System.out.println("Consumed message: " + message);
//        System.out.println(path);
//
//
//    }

//    @Autowired
//    private KafkaTemplate<String, PdfDocument> kafkaTemplate;
//
//    private static final String TOPIC = "FileText";

    /*
    This method will take path of PDF file as input parameter and return String in JSON Format
     */
    public String extractFromFile( String path ) throws IOException , SAXException, NullPointerException, FileNotFoundException, EmptyFileException,
            TikaException{


        Parser parser = new AutoDetectParser();
        PdfDocument pdfDocument = new PdfDocument();
        String uniqueID = UUID.randomUUID().toString();
        BodyContentHandler handler = new BodyContentHandler(1000000);
        Metadata metadata =new Metadata();

        FileInputStream content = new FileInputStream(path);
        if( content == null )
        {
            throw new FileNotFoundException(fileNotFound);
        }
        parser.parse(content,handler,metadata,new ParseContext());
        pdfDocument.setDocumentId(uniqueID);
        pdfDocument.setDocumentText(handler.toString());
        if( handler.toString().length()  == 0)
        {
            throw new EmptyFileException(EmptyFile);
        }

        JSONObject metaDataJson = new JSONObject();
        for( String name : metadata.names())
        {
            metaDataJson.put(name,metadata.get(name));
        }
        pdfDocument.setDocumentMetaData(metaDataJson);
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonString = objectWriter.writeValueAsString(pdfDocument);
        return jsonString;
    }



    /*
    This method will extract Pdf from URL
     */
    public  PdfDocument extractFromURL(String path1) throws IOException , SAXException, NullPointerException, FileNotFoundException, EmptyFileException,
            TikaException
    {
        System.out.println(path1);
        URL url=new URL(path1);
        TikaInputStream tikaInputStream =TikaInputStream.get(url.openStream());
        BodyContentHandler contenthandler = new BodyContentHandler(10*1024*1024);
        Metadata metadata = new Metadata();
        Parser parser = new AutoDetectParser();
        PdfDocument pdfDocument = new PdfDocument();
        parser.parse( tikaInputStream,contenthandler, metadata, new ParseContext());

        String uniqueID = UUID.randomUUID().toString();


        pdfDocument.setDocumentId(uniqueID);
        pdfDocument.setDocumentText(contenthandler.toString());
        if( contenthandler.toString().length()  == 0)
        {
            throw new EmptyFileException(EmptyFile);
        }

        JSONObject metaDataJson = new JSONObject();
        for( String name : metadata.names())
        {
            metaDataJson.put(name,metadata.get(name));
        }
        pdfDocument.setDocumentMetaData(metaDataJson);
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonString = objectWriter.writeValueAsString(pdfDocument);
       // kafkaTemplate.send(TOPIC, pdfDocument);
        System.out.println("extracted properly");
        return pdfDocument;
    }

}
