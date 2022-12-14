package com.allan.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity //cria as tabelas do banco automatico
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id // chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment no banco
	private Integer id;
	private String nome;
	
	
	@ManyToMany(mappedBy = "categorias") //puxa a relação que vc já fez do outro lado só que invertida
	private List<Produto> produtos = new ArrayList<>();
	
	public Categoria() {
		
	}

	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
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
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id);
	}

	


	
	
	
	
}
