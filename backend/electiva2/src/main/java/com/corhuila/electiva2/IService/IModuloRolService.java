package com.corhuila.electiva2.IService;

import java.util.List;
import java.util.Optional;

import com.corhuila.electiva2.Entity.ModuloRol;

public interface IModuloRolService {
	
	//Obtener todo
	public List<ModuloRol> all();
		
	//Obtener por ID
	public Optional<ModuloRol> findById(Long id);
	 	
	//Crear
	public ModuloRol save(ModuloRol moduloRol);
		
	//Modificar
	public void update(ModuloRol moduloRol, Long id);
		
	//Eliminar Físico
	public void deletePhysical(Long id);
			
	// Eliminar lógico
	public void deleteLogical(Long id);

}