package com.apilupuspub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apilupuspub.model.Email;
import com.apilupuspub.service.EmailService;

@RestController
public class EmailController {
	
	@Autowired
	EmailService emailServ;
	
	@PostMapping("/enviar-email")
	public String enviarEmail(@RequestBody Email email) {	
		JavaMailSenderImpl mailSender= emailServ.criarEnviador();
		System.out.println("\n#########   JavaMailSender criado  ##########\n");
		emailServ.enviarEmail(mailSender, email);
		return "Enviado";
	}
	
	@GetMapping("/testar")
	public String retornarTeste() {
		return "Está funcionando";
	}

}
