package com.apilupuspub.model;

public class Email {
	private String nomeCliente;
	private String emailCliente;
	private String textoCliente;
	
	public Email() {}
	
	public Email(String nomeCliente, String emailCliente, String textoCliente) {
		this.nomeCliente= nomeCliente;
		this.emailCliente= emailCliente;
		this.textoCliente= textoCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getTextoCliente() {
		return textoCliente;
	}

	public void setTextoCliente(String textoCliente) {
		this.textoCliente = textoCliente;
	}
}
