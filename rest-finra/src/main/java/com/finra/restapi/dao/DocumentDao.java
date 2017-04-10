package com.finra.restapi.dao;

import java.util.Date;
import java.util.List;

import com.finra.restapi.docs.Document;
import com.finra.restapi.docs.DocumentMetadata;

public interface DocumentDao {

    void insert(Document document);
    
    List<DocumentMetadata> findByPersonNameDate(String personName, Date date);
    
    List<DocumentMetadata> findByPersonNameBeforedateAfterdate(String personName, Date before, Date after);
    
    Document load(String uuid);
    
}
