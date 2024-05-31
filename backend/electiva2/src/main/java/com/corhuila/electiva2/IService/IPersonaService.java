package com.corhuila.electiva2.IService;

import java.util.List;
import java.util.Optional;

import com.corhuila.electiva2.Entity.Persona;

public interface IPersonaService {
	
	//Obtener todo
	public List<Persona> all();
		
	//Obtener por ID
	public Optional<Persona> findById(Long id);
	 	
	//Crear
	public Persona save(Persona persona);
		
	//Modificar
	public void update(Persona persona, Long id);
		
	//Eliminar Físico
	public void deletePhysical(Long id);
			
	// Eliminar lógico
	public void deleteLogical(Long id);

}