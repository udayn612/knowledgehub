package com.stackroute.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.stackroute.domain.PdfDocument;
import com.stackroute.exception.EmptyFileException;
import com.stackroute.exception.FileNotFoundException;
import org.apache.tika.exception.TikaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;
import org.json.simple.JSONObject;

import java.io.IOException;

public class PdfExtractionServiceTest {

    private PdfDocument pdfDocument;

    private PdfExtractionServiceImpl pdfExtractionService;
    public JSONObject metadata;

    @Before
    public void setUp() throws Exception
    {
        this.pdfExtractionService =new PdfExtractionServiceImpl();
        this.pdfDocument=new PdfDocument();

    }

    @Test
    public void testPdfServiceSuccess() throws TikaException, SAXException, IOException , FileNotFoundException , EmptyFileException {

        pdfDocument.setDocumentId("867e7615-cf2b-478d-a2d0-606f6e0edc60");
        pdfDocument.setDocumentText("\nAdobe Acrobat PDF Files\n\nAdobe® Portable Document Format (PDF) is a universal file format that preserves all\nof the fonts, formatting, colours and graphics of any source document, regardless of\nthe application and platform used to create it.\n\nAdobe PDF is an ideal format for electronic document distribution as it overcomes the\nproblems commonly encountered with electronic file sharing.\n\n• Anyone, anywhere can open a PDF file. All you need is the free Adobe Acrobat\nReader. Recipients of other file formats sometimes can\u0027t open files because they\ndon\u0027t have the applications used to create the documents.\n\n• PDF files always print correctly on any printing device.\n\n• PDF files always display exactly as created, regardless of fonts, software, and\noperating systems. Fonts, and graphics are not lost due to platform, software, and\nversion incompatibilities.\n\n• The free Acrobat Reader is easy to download and can be freely distributed by\nanyone.\n\n• Compact PDF files are smaller than their source files and download a\npage at a time for fast display on the Web.\n\n\n");
        metadata =new JSONObject();
        metadata.put("date" , "2013-10-28T19:24:13Z");
        metadata.put("pdf:PDFVersion" , "1.3");
        metadata.put("pdf:docinfo:title" , "This is a test PDF file");
        metadata.put("xmp:CreatorTool" , "Microsoft Word 8.0");
        metadata.put("access_permission:modify_annotations" , "true");
        metadata.put("access_permission:can_print_degraded" , "true");
        metadata.put("dc:creator" , "cdaily");
        metadata.put("dcterms:created" , "2000-06-28T23:21:08Z");
        metadata.put("Last-Modified" , "2013-10-28T19:24:13Z");
        metadata.put("dcterms:modified" , "2013-10-28T19:24:13Z");
        metadata.put("dc:format" , "application/pdf; version=1.3");
        metadata.put("title" , "This is a test PDF file");
        metadata.put("xmpMM:DocumentID" , "uuid:0805e221-80a8-459e-a522-635ed5c1e2e6");
        metadata.put("Last-Save-Date" , "2013-10-28T19:24:13Z");
        metadata.put("pdf:docinfo:creator_tool" , "Microsoft Word 8.0");
        metadata.put("access_permission:fill_in_form" , "true");
        metadata.put("pdf:docinfo:modified" , "2013-10-28T19:24:13Z");
        metadata.put("meta:save-date" , "2013-10-28T19:24:13Z");
        metadata.put("pdf:encrypted" , "false");
        metadata.put("dc:title" , "This is a test PDF file");
        metadata.put("modified" , "2013-10-28T19:24:13Z");
        metadata.put("Content-Type" , "application/pdf");
        metadata.put("pdf:docinfo:creator" , "cdaily");
        metadata.put("X-Parsed-By" , "org.apache.tika.parser.DefaultParser");
        metadata.put("creator" , "cdaily");
        metadata.put("meta:author" , "cdaily");
        metadata.put("meta:creation-date" , "2000-06-28T23:21:08Z");
        metadata.put("created" , "2000-06-28T23:21:08Z");
        metadata.put("access_permission:extract_for_accessibility" , "true");
        metadata.put("access_permission:assemble_document" , "true");
        metadata.put("xmp" + "TPg:NPages" , "1");
        metadata.put("Creation-Date" , "2000-06-28T23:21:08Z");
        metadata.put("access_permission:extract_content" , "true");
        metadata.put("access_permission:can_print" , "true");
        metadata.put("Author" , "cdaily");
        metadata.put("producer" , "Acrobat Distiller 4.0 for Windows");
        metadata.put("access_permission:can_modify" , "true");
        metadata.put("pdf:docinfo:producer" , "Acrobat Distiller 4.0 for Windows");
        metadata.put("pdf:docinfo:created" , "2000-06-28T23:21:08Z");

        pdfDocument.setDocumentMetaData(metadata);

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonString = objectWriter.writeValueAsString(pdfDocument);

        String actualString= pdfExtractionService.extractFromFile("src/main/resources/static/pdf-sample.pdf");

        Assert.assertEquals(jsonString.substring(58), actualString.substring(58));

    }

    @Test
    public void testPdfServiceFailure() throws TikaException, SAXException, IOException , FileNotFoundException , EmptyFileException {

        pdfDocument.setDocumentId("867e7615-cf2b-478d-a2d0-606f6e0edc60");
        pdfDocument.setDocumentText("\nAdobe Acrobat PDF Files\n\nAdobe® Portable Document Format (PDF) is a universal file format that preserves all\nof the fonts, formatting, colours and graphics of any source document, regardless of\nthe application and platform used to create it.\n\nAdobe PDF is an ideal format for electronic document distribution as it overcomes the\nproblems commonly encountered with electronic file sharing.\n\n• Anyone, anywhere can open a PDF file. All you need is the free Adobe Acrobat\nReader. Recipients of other file formats sometimes can\u0027t open files because they\ndon\u0027t have the applications used to create the documents.\n\n• PDF files always print correctly on any printing device.\n\n• PDF files always display exactly as created, regardless of fonts, software, and\noperating systems. Fonts, and graphics are not lost due to platform, software, and\nversion incompatibilities.\n\n• The free Acrobat Reader is easy to download and can be freely distributed by\nanyone.\n\n• Compact PDF files are smaller than their source files and download a\npage at a time for fast display on the Web.\n\n\n");
        metadata =new JSONObject();
        metadata.put("date" , "2013-10-28T19:24:13Z");
        metadata.put("pdf:PDFVersion" , "1.3");
        metadata.put("pdf:docinfo:title" , "This is a test PDF file");
        metadata.put("xmp:CreatorTool" , "Microsoft Word 8.0");
        metadata.put("access_permission:modify_annotations" , "true");
        metadata.put("access_permission:can_print_degraded" , "true");
        metadata.put("dc:creator" , "cdaily");
        metadata.put("dcterms:created" , "2000-06-28T23:21:08Z");
        metadata.put("Last-Modified" , "2013-10-28T19:24:13Z");
        metadata.put("dcterms:modified" , "2013-10-28T19:24:13Z");
        metadata.put("dc:format" , "application/pdf; version=1.3");
        metadata.put("title" , "This is a test PDF file");
        metadata.put("xmpMM:DocumentID" , "uuid:0805e221-80a8-459e-a522-635ed5c1e2e6");
        metadata.put("Last-Save-Date" , "2013-10-28T19:24:13Z");
        metadata.put("pdf:docinfo:creator_tool" , "Microsoft Word 8.0");
        metadata.put("access_permission:fill_in_form" , "true");
        metadata.put("pdf:docinfo:modified" , "2013-10-28T19:24:13Z");
        metadata.put("meta:save-date" , "2013-10-28T19:24:13Z");
        metadata.put("pdf:encrypted" , "false");
        metadata.put("dc:title" , "This is a test PDF file");
        metadata.put("modified" , "2013-10-28T19:24:13Z");
        metadata.put("Content-Type" , "application/pdf");
        metadata.put("pdf:docinfo:creator" , "cdaily");
        metadata.put("X-Parsed-By" , "org.apache.tika.parser.DefaultParser");
        metadata.put("creator" , "cdaily");
        metadata.put("meta:author" , "cdaily");
        metadata.put("meta:creation-date" , "2000-06-28T23:21:08Z");
        metadata.put("created" , "2000-06-28T23:21:08Z");
        metadata.put("access_permission:extract_for_accessibility" , "true");
        metadata.put("access_permission:assemble_document" , "true");
        metadata.put("xmp" + "TPg:NPages" , "1");
        metadata.put("Creation-Date" , "2000-06-28T23:21:08Z");
        metadata.put("access_permission:extract_content" , "true");
        metadata.put("access_permission:can_print" , "true");
        metadata.put("Author" , "cdaily");
        metadata.put("producer" , "Acrobat Distiller 4.0 for Windows");
        metadata.put("access_permission:can_modify" , "true");
        metadata.put("pdf:docinfo:producer" , "Acrobat Distiller 4.0 for Windows");
        metadata.put("pdf:docinfo:created" , "2000-06-28T23:21:08Z");

        pdfDocument.setDocumentMetaData(metadata);

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonString = objectWriter.writeValueAsString(pdfDocument);

        String actualString= pdfExtractionService.extractFromFile("src/main/resources/static/pdf-sample.pdf");

        Assert.assertNotEquals(jsonString.substring(58), actualString.substring(60));

    }

}
