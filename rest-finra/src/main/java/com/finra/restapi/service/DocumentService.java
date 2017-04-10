package com.finra.restapi.service;

import java.util.Date;
import java.util.List;

import com.finra.restapi.docs.Document;
import com.finra.restapi.docs.DocumentMetadata;


public interface DocumentService {
    
    DocumentMetadata save(Document document);
    
    List<DocumentMetadata> findDocuments(String personName, Date date);
    
    byte[] getDocumentFile(String id);

	List<DocumentMetadata> findDocumentsByCriteria(String person, Date before, Date after);
}
