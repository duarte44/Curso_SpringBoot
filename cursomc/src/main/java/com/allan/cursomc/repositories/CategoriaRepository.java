package com.allan.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allan.cursomc.domain.Categoria;

@Repository // acessa o banco na tabela que deseja 
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
 //extende o jpa e coloca o nome do tipo, e o tipo do atributo que vai pegar
	
	
}
