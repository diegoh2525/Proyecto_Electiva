package com.corhuila.electiva2.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.electiva2.Entity.Rol;
import com.corhuila.electiva2.IRepository.IRolRepository;
import com.corhuila.electiva2.IService.IRolService;

@Service
public class RolService implements IRolService {

	@Autowired
	private IRolRepository repository;
	
	@Override
	public List<Rol> all() {
		return repository.findAll();
	}

	@Override
	public Optional<Rol> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Rol save(Rol rol) {
		rol.setFechaCreacion(LocalDateTime.now());
		return repository.save(rol);
	}

	@Override
	public void update(Rol rol, Long id) {
		//validar si existe.            
        Optional<Rol> op = repository.findById(id);		
        
        if(op.isEmpty()){
            System.out.println("Dato no encontrado");
        }else {
        	 //Crear nuevo objeto que va a contener los datos que se van actualizar
            Rol rolUpdate = op.get();
            rolUpdate.setNombre(rol.getNombre());
            rolUpdate.setCodigo(rol.getCodigo());
            rolUpdate.setDescripcion(rol.getDescripcion());
            rolUpdate.setFechaModificacion(LocalDateTime.now());
            
            //Actualizar el objeto
            repository.save(rolUpdate);
        }
        
        
	}

	@Override
	public void deletePhysical(Long id) {
		repository.deleteById(id);	
	}

	@Override
	public void deleteLogical(Long id) {
		//validar si existe.            
        Optional<Rol> op = repository.findById(id);		
        
        if(op.isEmpty()){
            System.out.println("Dato no encontrado");
        }else {
        	 //Crear nuevo objeto que va a contener los datos que se van actualizar
            Rol rolUpdate = op.get();
            rolUpdate.setFechaEliminacion(LocalDateTime.now());
            
            //Actualizar el objeto
            repository.save(rolUpdate);
        }		
	}	
}