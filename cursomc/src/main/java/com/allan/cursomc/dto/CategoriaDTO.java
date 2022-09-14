package com.allan.cursomc.dto;


import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.allan.cursomc.domain.Categoria;




public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	//DTO DEFINE O QUE VAI SER VOLTADO, EX: SE RETORNAR TUDO DE CATEGORIA, QUERO VOLTAR SÓ CATEGORIAS, SEM OS PRODUTOS
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório") //n deisa ser nulo
	@Length(min=5, max=80, message="O tamnho deve ser entre 5 e 80 caracteres")
	private String nome;
	
	public CategoriaDTO() {
		
	}
	
	public CategoriaDTO(Categoria obj) {
		id = obj.getId();
		nome = obj.getNome();		
		
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
	
	
	
}
