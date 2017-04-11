package com.finra.schedulers;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.finra.restapi.dao.DocumentDao;
import com.finra.restapi.docs.DocumentMetadata;


@Component
public class FinraScheduler {
	private static final Logger log = LoggerFactory.getLogger(FinraScheduler.class);
    
    private static final long INITIAL_DELAY = 60000L; // 60 seconds
    private static final long PERIOD = 60000L;
//    private static final long LAST_RECENT = 60000L;
    private static String ADMIN_EMAIL="";
    
    @Autowired
    DocumentDao documentDao;
    
    /*
     * task scheduled for every hour (a 60s after completion of previous task)
     */
    @Scheduled(initialDelay=INITIAL_DELAY, fixedDelay = PERIOD)
    public void pollAndEmail() throws IOException {
    	List<DocumentMetadata> list = doPollRecentDocuments();
    	if(list!= null && !(list.isEmpty()) ){
    		doEmailToAdmin(list);
    	}
    }
    
	/*
	 * polls for documents in the last 'duration' seconds
	 */
	public List<DocumentMetadata> doPollRecentDocuments() throws IOException{
		Date date = new Date();
        List<DocumentMetadata> metadataList = documentDao.getRecentList(date); 
		return metadataList;
	}
	
	
	/*
	 * email the list of documents' information acquired through polling
	 * and sent to the email address to ADMIN_EMAIL
	 */
	public void doEmailToAdmin(List<DocumentMetadata> docList){
		//TODO
		
	}
	
	public void doEmailTo(List<DocumentMetadata> docList, String emailID){
		
	}
    
}
