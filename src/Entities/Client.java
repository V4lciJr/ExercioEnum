package Entities;

import java.util.Date;

public class Client {
	
	// Definição dos atributos
	
	private String name;
	private String email;
	private Date birthDate;
	
	// Construtor padrão
	public Client()
	{
		
	}
	
	// Construtor com argumentos
	public Client(String name, String email, Date birthDate) {
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
	}
	
	// Getters e setters padrão
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	
}
