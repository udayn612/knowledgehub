//package com.stackroute.controller;
//
//import com.stackroute.domain.FileUrl;
//import com.stackroute.domain.PdfDocument;
//import com.stackroute.exception.EmptyFileException;
//import com.stackroute.exception.FileNotFoundException;
//import com.stackroute.service.PdfExtractionService;
//import com.stackroute.service.PdfExtractionServiceImpl;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.apache.tika.exception.TikaException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import org.xml.sax.SAXException;
//
//import java.io.File;
//import java.io.IOException;
//
//@CrossOrigin(origins = "*")
//@Controller
//@PropertySource(value = "classpath:application.properties")
//public class PdfController {
//
//        private PdfExtractionService contentExtractionService;
//
////        @Autowired
////        private KafkaTemplate<String, String> kafkaTemplate;
////
////        @Autowired
////        private KafkaTemplate<String,FileUrl> kafkaTemplate1;
//
//     //   private KafkaConsumer kafkaConsumer;
//
// //   KafkaConsumer kafkaConsumer
////    , KafkaTemplate<String, String> kafkaTemplate
////                ,KafkaTemplate<String,FileUrl> kafkaTemplate1
//        @Autowired
//        public PdfController(PdfExtractionService contentExtractionService)
//        {
//            this.contentExtractionService = contentExtractionService;
//            //this.kafkaTemplate =kafkaTemplate;
//           // this.kafkaTemplate1 =kafkaTemplate1;
//            //this.kafkaConsumer=kafkaConsumer;
//
//        }
//        private static final String TOPIC = "Content_Format";
//
//        @Value("${fileNotFound}")
//        private String fileNotFound;
//
//        private String path;
//        File file1;
//
//        //In this Method, We need to Upload the PDF file
//        @PostMapping("/file")
//        public ResponseEntity<String> fileUpload(@RequestParam("file")  MultipartFile file) {
//            File convFile = new File( file.getOriginalFilename());
//
//            String message = "";
//            try {
//                file.transferTo(convFile);
//                path = convFile.getAbsolutePath();
//                file1=convFile;
//                message = "You successfully uploaded !";
//                return ResponseEntity.status(HttpStatus.OK).body(message);
//            } catch (Exception e) {
//                message = "FAIL to upload " + convFile.getAbsolutePath() + "!";
//                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
//            }
//        }
//
//        // This method will call Service Class to convert PDF to JSON Format then return the response body in Postman
//        @GetMapping("/result")
//        @ResponseBody
//        public ResponseEntity<String> getFile() throws TikaException, SAXException, IOException, FileNotFoundException, EmptyFileException {
//            try {
//                String jsonString = contentExtractionService.extractFromFile(path);
//               // kafkaTemplate.send(TOPIC,jsonString);
//                return ResponseEntity.status(HttpStatus.OK).body(jsonString);
//
//            } catch (Exception e) {
//                String message =fileNotFound;
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
//            }
//
//        }
//
//        //Uploading the URL of PDF
//
//        @PostMapping("/pdfUrl")
//        public ResponseEntity<String> postFileUrl(@RequestBody FileUrl fileUrl) throws TikaException, SAXException, IOException, FileNotFoundException, EmptyFileException
//        {
//            try
//            {
//                path = fileUrl.getFileUrl();
//                return ResponseEntity.status(HttpStatus.OK).body("Url has been uploaded!!");
//            }
//            catch (Exception e)
//            {
//                String message = path + " is not available";
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
//            }
//        }
//
//        //Getting the data from the Uploaded URL
//        @GetMapping("/pdfUrl")
//        public ResponseEntity<String> getFileFromUrl() throws TikaException, SAXException, IOException, FileNotFoundException, EmptyFileException
//        {
//            System.out.println("hello");
//            try
//            {
//                PdfDocument jsonString = contentExtractionService.extractFromURL();
//               // kafkaTemplate.send(TOPIC,jsonString);
//                return ResponseEntity.status(HttpStatus.OK).body(jsonString.toString());
//            }
//            catch (Exception e)
//            {
//                String message =fileNotFound;
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
//            }
//        }
//}
