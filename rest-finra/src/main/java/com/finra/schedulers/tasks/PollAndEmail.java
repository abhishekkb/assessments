package com.finra.schedulers.tasks;

import java.util.List;

import com.finra.restapi.docs.DocumentMetadata;

public class PollAndEmail {
	private static String ADMIN_EMAIL;
	
	/*
	 * polls for documents in the last 'duration' seconds
	 */
	public List<DocumentMetadata> doPollRecentDocuments(Long duration){
		
		
		return null;
	}
	
	/*
	 * email the list of documents' information acquired through polling
	 * and sent to the email address to ADMIN_EMAIL
	 */
	public void doEmailToAdmin(List<DocumentMetadata> docList){
		
	}
	
	public void doEmailTo(List<DocumentMetadata> docList, String emailID){
		
	}
}
