package org.ibm.sterling_ticks.services;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.ibm.sterling_ticks.model.entities.EmailTemplate;
import org.ibm.sterling_ticks.utils.*;

@Service
public class MailService {

	@Autowired
	private JavaMailSender mailer;
	
	@Value("${spring.mail.username}")
	private String fromEmail;
	
	public boolean sendMail(String email, String subject, String body) {
		MimeMessage mail = mailer.createMimeMessage();
		
		try {
			MimeMessageHelper helper;
			helper = new MimeMessageHelper(mail, true, "UTF-8");
			helper.setFrom(fromEmail);
			helper.setTo(email);
			helper.setSubject(subject);
			helper.setText(body, true);
			mailer.send(mail);
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return true;
	}
	
	public boolean sendOtpMail(String email, int otp) throws IOException {
		EmailTemplate template = FileUtil.readOtpEmailTemplate();
		template.body = String.format(template.body, String.valueOf(otp));
		
		return sendMail(email, template.subject, template.body);
	}
}
