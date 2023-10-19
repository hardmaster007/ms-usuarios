package cl.pruebadespring.model.repository;

import org.springframework.data.repository.CrudRepository;

import cl.pruebadespring.model.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	
	
}
