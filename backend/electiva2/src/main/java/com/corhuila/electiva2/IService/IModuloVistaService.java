package com.corhuila.electiva2.IService;

import java.util.List;
import java.util.Optional;

import com.corhuila.electiva2.Entity.ModuloVista;

public interface IModuloVistaService {
	
	//Obtener todo
	public List<ModuloVista> all();
		
	//Obtener por ID
	public Optional<ModuloVista> findById(Long id);
	 	
	//Crear
	public ModuloVista save(ModuloVista moduloVista);
		
	//Modificar
	public void update(ModuloVista moduloVista, Long id);
		
	//Eliminar Físico
	public void deletePhysical(Long id);
			
	// Eliminar lógico
	public void deleteLogical(Long id);

}