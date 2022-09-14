package com.allan.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.allan.cursomc.domain.Categoria;
import com.allan.cursomc.dto.CategoriaDTO;
import com.allan.cursomc.repositories.CategoriaRepository;
import com.allan.cursomc.services.exceptions.DataIntegrityException;
import com.allan.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
// faz as requições 
	
	@Autowired
	private CategoriaRepository repo; //instancia para fazer requisições no banco
				
		public Categoria find(Integer id) {
			 Optional<Categoria> obj = repo.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFoundException(
			 "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
			 
	} 
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
		
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma categoria que tem produtos");
		}
	}

	public List<Categoria> findAll(){
		return repo.findAll();
	}
	
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Categoria fromDTO(CategoriaDTO objDto) {
		return new Categoria(objDto.getId(), objDto.getNome());
	}
	
}
