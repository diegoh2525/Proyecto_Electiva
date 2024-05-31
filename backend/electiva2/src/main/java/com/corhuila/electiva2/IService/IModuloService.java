package com.corhuila.electiva2.IService;

import java.util.List;
import java.util.Optional;

import com.corhuila.electiva2.Entity.Modulo;

public interface IModuloService {
	
	//Obtener todo
	public List<Modulo> all();
		
	//Obtener por ID
	public Optional<Modulo> findById(Long id);
	 	
	//Crear
	public Modulo save(Modulo modulo);
		
	//Modificar
	public void update(Modulo modulo, Long id);
		
	//Eliminar Físico
	public void deletePhysical(Long id);
			
	// Eliminar lógico
	public void deleteLogical(Long id);

}