package com.example.demo;

import javax.security.enterprise.credential.Password;

public class Utente {

	private String username;
	private String email;
	private Password password;
	private String nome;
	private String cognome;
	private String provincia;
	private int cap;
	private String città;
	private String via;
	private int numero;
	private String ruolo=null;
	
	public Utente() {}
	
	public Utente(String username, String email, Password password, String nome, String cognome, String provincia, int cap,String città, String via, int numero)
	{
		this.setUsername(username);
		this.setEmail(email);
		this.setPassword(password);
		this.setNome(nome);
		this.setCognome(cognome);
		this.setProvincia(provincia);
		this.setCap(cap);
		this.setCittà(città);
		this.setVia(via);
		this.setNumero(numero);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Password getPassword()
	{
		return password;
	}

	public void setPassword(Password password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getCap() {
		return cap;
	}

	public void setCap(int cap) {
		this.cap = cap;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCittà() {
		return città;
	}

	public void setCittà(String città) {
		this.città = città;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	
}
