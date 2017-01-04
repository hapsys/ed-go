package org.c3s.edgo.mail;

import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {
	
	public void send(String from, String to, String subject, String body) throws AddressException, MessagingException {
		Properties props = System.getProperties();
		if (props.getProperty("mail.smtp.host") == null) {
			Map<String,String> senv = System.getenv();
			for (String key: senv.keySet()) {
				if (key.startsWith("mail.")) {
					props.put(key, senv.get(key));
				}
			}
		}
		//props.put("java.security.debug", "all");
		//props.put("javax.net.ssl.debug", "all");
		//props.put("mail.debug",true);
		
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(props.getProperty("mail.smtp.user"), props.getProperty("mail.smtp.password"));
            }			
		}); 
		
		//session.setDebug(true);
		
		MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(subject, "utf-8");
        message.setSentDate(new Date());
        message.setContent(body, "text/html; charset=UTF-8");

        Transport.send(message);		
	}

}
