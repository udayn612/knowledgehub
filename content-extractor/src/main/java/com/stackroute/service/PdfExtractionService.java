package com.stackroute.service;

import com.stackroute.domain.PdfDocument;
import com.stackroute.exception.EmptyFileException;
import com.stackroute.exception.FileNotFoundException;
import org.apache.tika.exception.TikaException;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import java.io.IOException;

@Service
public interface PdfExtractionService {

    public String extractFromFile(String path) throws IOException, SAXException,
            TikaException,FileNotFoundException, EmptyFileException;


    public PdfDocument extractFromURL(String path) throws IOException , SAXException, NullPointerException, FileNotFoundException, EmptyFileException,
            TikaException;
}



