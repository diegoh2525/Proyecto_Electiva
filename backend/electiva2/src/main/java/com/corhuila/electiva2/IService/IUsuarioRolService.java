package com.corhuila.electiva2.IService;

import java.util.List;
import java.util.Optional;

import com.corhuila.electiva2.Entity.UsuarioRol;

public interface IUsuarioRolService {
	
	//Obtener todo
	public List<UsuarioRol> all();
		
	//Obtener por ID
	public Optional<UsuarioRol> findById(Long id);
	 	
	//Crear
	public UsuarioRol save(UsuarioRol usuarioRol);
		
	//Modificar
	public void update(UsuarioRol usuarioRol, Long id);
		
	//Eliminar Físico
	public void deletePhysical(Long id);
			
	// Eliminar lógico
	public void deleteLogical(Long id);

}