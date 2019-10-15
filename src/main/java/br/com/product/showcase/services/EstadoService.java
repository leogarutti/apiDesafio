package br.com.product.showcase.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.product.showcase.entity.Estado;
import br.com.product.showcase.repositories.EstadoRepository;
import br.com.product.showcase.services.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository repoEstado;

    public Estado find(Integer id) {
	Optional<Estado> obj = repoEstado.findById(id);
	return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Estado.class.getName()));
    }
}
