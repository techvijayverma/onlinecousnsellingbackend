package org.cdac.services;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
public class GmailAuthenticator extends Authenticator {

	String username;
	String password;
	
	public GmailAuthenticator(String username,String password)
	{
		super();
		this.username=username;
		this.password=password;
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		
		return new PasswordAuthentication(username,password);
	}
	
	

}
