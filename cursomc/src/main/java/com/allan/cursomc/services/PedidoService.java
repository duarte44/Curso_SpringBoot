package com.allan.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allan.cursomc.domain.Pedido;
import com.allan.cursomc.repositories.PedidoRepository;
import com.allan.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
// faz as requições 
	
	@Autowired
	private PedidoRepository repo; //instancia para fazer requisições no banco
				
		public Pedido find(Integer id) {
			 Optional<Pedido> obj = repo.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFoundException(
			 "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
			 
	} 
	
	


}
