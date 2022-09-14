package com.allan.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.allan.cursomc.domain.Cliente;

public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L; 
	
	//VAI FICAR RESPONSÁVEL POR PASSAR O QUE PODE SER ALTERADO DO CLIENTE
	
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório") //n deixa ser nulo
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email Invalido")
	private String email;
	
	public ClienteDTO() {
		
	}
	
	public ClienteDTO(Cliente obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
