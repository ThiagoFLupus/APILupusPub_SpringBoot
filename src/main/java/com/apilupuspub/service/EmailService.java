package com.apilupuspub.service;

import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.apilupuspub.model.Email;

/* O ideal é que as configurações de e-mail abaixo
 * referentes a JavaMailSender e SimpleMailMessage
 * sejam colocadas em classes à parte para 
 * melhor organização do código.		 * 
 */


@Service
public class EmailService {
	JavaMailSenderImpl mailSenderLupus;	
	
	
	public EmailService() {
		mailSenderLupus= new JavaMailSenderImpl();
	}
	
	public JavaMailSenderImpl criarEnviador() {
		System.out.println("\n#########   Inicio da criaçao de JavaMailSender  ##########\n");
		this.mailSenderLupus.setHost("smtp.gmail.com");
		this.mailSenderLupus.setPort(587);
		//conta do gmail
		this.mailSenderLupus.setUsername("xxxxxxxxxxxxxx@yyyyyyyy.com");
		//senha da conta do gmail
		this.mailSenderLupus.setPassword("**********");
		
		System.out.println("\n#########   Criaçao de propriedades de JavaMailSender  ##########\n");
		
		Properties props= new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.starttls.required", "true");
		props.put("mail.smtp.ssl.enable", "false");
		props.put("mail.smtp.connectiontimeout", 50000);
		
		mailSenderLupus.setJavaMailProperties(props);
		
		return this.mailSenderLupus;
	}
	
	public void enviarEmail(JavaMailSenderImpl enviador, Email emailCliente){
		System.out.println("\n#########   Inicio da criaçao de SimpleMailMessage  ##########\n");
		SimpleMailMessage envioLupus= new SimpleMailMessage();
		SimpleMailMessage envioCliente= new SimpleMailMessage();
		String textoPadrao= "A Lupus Pub agradece pelo envio de sua sugestão/reclamação. Estaremos atentos para melhor atendê-lo(a).\n\n";
		
		envioLupus.setFrom(enviador.getUsername());
		envioLupus.setTo(enviador.getUsername());
		envioLupus.setSubject("Sugestão / Reclamação: " + emailCliente.getNomeCliente());
		envioLupus.setText(emailCliente.getTextoCliente());
		
		envioCliente.setFrom(enviador.getUsername());
		envioCliente.setTo(emailCliente.getEmailCliente());
		envioCliente.setSubject("Confirmaçao de recebimento de sugestão/reclamação");
		envioCliente.setText("Olá, " + emailCliente.getNomeCliente() + "," + "\n\n" + textoPadrao + "Seu envio: " + emailCliente.getTextoCliente());
		
		System.out.println("\n#########   Pronto para envio  ##########\n");
		
		this.mailSenderLupus.send(envioLupus);
		this.mailSenderLupus.send(envioCliente);
		
		System.out.println("\n#########   Termino de execuçao do metodo send()  ##########\n");
	}
}
