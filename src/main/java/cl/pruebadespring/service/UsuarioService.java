package cl.pruebadespring.service;

import java.util.Optional;

import cl.pruebadespring.model.entity.Usuario;

public interface UsuarioService {
	
	public Iterable<Usuario> findAll();
	
	public Optional<Usuario>findById(Long id);
	
	public Usuario save(Usuario usuario);
	
	public void deleteById(Long id);

}
