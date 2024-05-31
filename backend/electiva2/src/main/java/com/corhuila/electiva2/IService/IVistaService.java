package com.corhuila.electiva2.IService;

import java.util.List;
import java.util.Optional;

import com.corhuila.electiva2.Entity.Vista;

public interface IVistaService {
	
	//Obtener todo
	public List<Vista> all();
		
	//Obtener por ID
	public Optional<Vista> findById(Long id);
	 	
	//Crear
	public Vista save(Vista vista);
		
	//Modificar
	public void update(Vista vista, Long id);
		
	//Eliminar Físico
	public void deletePhysical(Long id);
			
	// Eliminar lógico
	public void deleteLogical(Long id);

}