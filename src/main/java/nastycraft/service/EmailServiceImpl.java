package nastycraft.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import nastycraft.query.MCQuery;
import nastycraft.query.QueryResponse;

@Service
@Transactional
@Component
public class EmailServiceImpl{
  
    @Autowired
    public JavaMailSender emailSender;
    
    @Autowired
    private NewsletterService newsletterService;
    
    
    private String subject;
    private String textarea;
    
    public EmailServiceImpl() {};
    

    public EmailServiceImpl(String subject, String textarea) {
		this.subject = subject;
		this.textarea = textarea;
	}


	public void sendSimpleMessage(String to, String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        emailSender.send(message);

    }

	
	
	public void sendEmails() {
		for(int i = 0; i < newsletterService.findAll().size();i++) {
			sendSimpleMessage(newsletterService.findAll().get(i).getEmail(), this.subject, this.textarea);
		}
	}
	
	public int howManyEmails() {
		int available = newsletterService.findAll().size();
		return available;
	}

	public JavaMailSender getEmailSender() {
		return emailSender;
	}


	public void setEmailSender(JavaMailSender emailSender) {
		this.emailSender = emailSender;
	}

	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getTextarea() {
		return textarea;
	}


	public void setTextarea(String textarea) {
		this.textarea = textarea;
	}
	
	
}