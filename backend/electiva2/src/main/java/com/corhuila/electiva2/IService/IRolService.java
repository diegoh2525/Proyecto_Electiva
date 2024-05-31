package com.corhuila.electiva2.IService;

import java.util.List;
import java.util.Optional;

import com.corhuila.electiva2.Entity.Rol;

public interface IRolService {
	
	//Obtener todo
	public List<Rol> all();
		
	//Obtener por ID
	public Optional<Rol> findById(Long id);
	 	
	//Crear
	public Rol save(Rol rol);
		
	//Modificar
	public void update(Rol rol, Long id);
		
	//Eliminar Físico
	public void deletePhysical(Long id);
			
	// Eliminar lógico
	public void deleteLogical(Long id);

}