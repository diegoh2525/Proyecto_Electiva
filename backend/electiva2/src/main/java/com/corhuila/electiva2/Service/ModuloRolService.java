package com.corhuila.electiva2.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.electiva2.Entity.ModuloRol;
import com.corhuila.electiva2.IRepository.IModuloRolRepository;
import com.corhuila.electiva2.IService.IModuloRolService;

@Service
public class ModuloRolService implements IModuloRolService {

	@Autowired
	private IModuloRolRepository repository;
	
	@Override
	public List<ModuloRol> all() {
		return repository.findAll();
	}

	@Override
	public Optional<ModuloRol> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public ModuloRol save(ModuloRol moduloRol) {
		moduloRol.setFechaCreacion(LocalDateTime.now());
		return repository.save(moduloRol);
	}

	@Override
	public void update(ModuloRol moduloRol, Long id) {
		//validar si existe.            
        Optional<ModuloRol> op = repository.findById(id);		
        
        if(op.isEmpty()){
            System.out.println("Dato no encontrado");
        }else {
        	 //Crear nuevo objeto que va a contener los datos que se van actualizar
            ModuloRol moduloRolUpdate = op.get();
            moduloRolUpdate.setModuloId(moduloRol.getModuloId());
            moduloRolUpdate.setRolId(moduloRol.getRolId());
            moduloRolUpdate.setFechaModificacion(LocalDateTime.now());
            
            //Actualizar el objeto
            repository.save(moduloRolUpdate);
        }
        
        
	}

	@Override
	public void deletePhysical(Long id) {
		repository.deleteById(id);	
	}

	@Override
	public void deleteLogical(Long id) {
		//validar si existe.            
        Optional<ModuloRol> op = repository.findById(id);		
        
        if(op.isEmpty()){
            System.out.println("Dato no encontrado");
        }else {
        	 //Crear nuevo objeto que va a contener los datos que se van actualizar
            ModuloRol moduloRolUpdate = op.get();
            moduloRolUpdate.setFechaEliminacion(LocalDateTime.now());
            
            //Actualizar el objeto
            repository.save(moduloRolUpdate);
        }		
	}	
}