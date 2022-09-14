package com.allan.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allan.cursomc.domain.Cliente;
import com.allan.cursomc.repositories.ClienteRepository;
import com.allan.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
// faz as requições 
	
	@Autowired
	private ClienteRepository repo; //instancia para fazer requisições no banco
				
		public Cliente find(Integer id) {
			 Optional<Cliente> obj = repo.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFoundException(
			 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
			 
	} 
	
	


}
