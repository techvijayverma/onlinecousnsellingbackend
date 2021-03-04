package org.cdac.services;

public interface MailService {
	
	public void sendMail(String to, String subject, String message) throws Exception;

}
