package com.finra.restapi.controllers;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.finra.restapi.docs.Document;
import com.finra.restapi.docs.DocumentMetadata;
import com.finra.restapi.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * REST web service for uploading and storing files on file system 
 * 
 * /finrarest/upload?file={file}&person={person}&date={date}  Add a document  POST
 *   metadata : person, date 
 *   file: file in a multipart request
 *   
 * /finrarest/documents?person={person}&date={date}           Find documents  GET
 *   
 * /finrarest/document/{id}                                   Get a document  GET
 * 
 */
@Controller
@RequestMapping(value = "/finrarest")
public class FinraController {

    private static final Logger LOG = Logger.getLogger(FinraController.class);
    
    @Autowired
    DocumentService documentService;

    /*
     * /finrarest/upload?file={file}&person={person}&date={date} [POST]
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody DocumentMetadata handleFileUpload(
            @RequestParam(value="file", required=true) MultipartFile file ,
            @RequestParam(value="person", required=true) String person,
            @RequestParam(value="date", required=true) @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
        
        try {
            Document document = new Document(file.getBytes(), file.getOriginalFilename(), date, person );
            getDocumentService().save(document);
            return document.getMetadata();
        } catch (RuntimeException e) {
            LOG.error("Error while uploading.", e);
            throw e;
        } catch (Exception e) {
            LOG.error("Error while uploading.", e);
            throw new RuntimeException(e);
        }      
    }
    
    /**
     * gives a list of document-meta-data 
     * 
     * /finrarest/documents?person={person}&date={date} [GET]
     * 
     */
    @RequestMapping(value = "/documents", method = RequestMethod.GET)
    public HttpEntity<List<DocumentMetadata>> findDocument(
            @RequestParam(value="person", required=false) String person,
            @RequestParam(value="date", required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<List<DocumentMetadata>>(getDocumentService().findDocuments(person,date), httpHeaders,HttpStatus.OK);
    }
    
    /**
     * gives a list of document-meta-data  based on criteria
     * 
     * /finrarest/search?person={person}&before={before}&after={after} [GET]
     * 
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public HttpEntity<List<DocumentMetadata>> findDocumentsByCriteria(
            @RequestParam(value="person", required=false) String person,
            @RequestParam(value="before", required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date before,
            @RequestParam(value="after", required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date after) {
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<List<DocumentMetadata>>(getDocumentService().findDocumentsByCriteria(person,before, after), httpHeaders,HttpStatus.OK);
    }
    
    /**
     * get a document with an id
     * 
     * /finrarest/document/{id} [GET]
     * 
     */
    @RequestMapping(value = "/document/{id}", method = RequestMethod.GET)
    public HttpEntity<byte[]> getDocument(@PathVariable String id) {         
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<byte[]>(getDocumentService().getDocumentFile(id), httpHeaders, HttpStatus.OK);
    }

    public DocumentService getDocumentService() {
        return documentService;
    }

    public void setArchiveService(DocumentService documentService) {
        this.documentService = documentService;
    }

}
