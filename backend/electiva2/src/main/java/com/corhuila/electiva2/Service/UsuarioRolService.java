package com.corhuila.electiva2.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.electiva2.Entity.UsuarioRol;
import com.corhuila.electiva2.IRepository.IUsuarioRolRepository;
import com.corhuila.electiva2.IService.IUsuarioRolService;

@Service
public class UsuarioRolService implements IUsuarioRolService {

	@Autowired
	private IUsuarioRolRepository repository;
	
	@Override
	public List<UsuarioRol> all() {
		return repository.findAll();
	}

	@Override
	public Optional<UsuarioRol> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public UsuarioRol save(UsuarioRol usuarioRol) {
		usuarioRol.setFechaCreacion(LocalDateTime.now());
		return repository.save(usuarioRol);
	}

	@Override
	public void update(UsuarioRol usuarioRol, Long id) {
		//validar si existe.            
        Optional<UsuarioRol> op = repository.findById(id);		
        
        if(op.isEmpty()){
            System.out.println("Dato no encontrado");
        }else {
        	 //Crear nuevo objeto que va a contener los datos que se van actualizar
            UsuarioRol usuarioRolUpdate = op.get();
            usuarioRolUpdate.setUsuarioId(usuarioRol.getUsuarioId());
            usuarioRolUpdate.setRolId(usuarioRol.getRolId());
            usuarioRolUpdate.setFechaModificacion(LocalDateTime.now());
            
            //Actualizar el objeto
            repository.save(usuarioRolUpdate);
        }
        
        
	}

	@Override
	public void deletePhysical(Long id) {
		repository.deleteById(id);	
	}

	@Override
	public void deleteLogical(Long id) {
		//validar si existe.            
        Optional<UsuarioRol> op = repository.findById(id);		
        
        if(op.isEmpty()){
            System.out.println("Dato no encontrado");
        }else {
        	 //Crear nuevo objeto que va a contener los datos que se van actualizar
            UsuarioRol usuarioRolUpdate = op.get();
            usuarioRolUpdate.setFechaEliminacion(LocalDateTime.now());
            
            //Actualizar el objeto
            repository.save(usuarioRolUpdate);
        }		
	}	
}