package com.corhuila.electiva2.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.electiva2.Entity.Persona;
import com.corhuila.electiva2.IRepository.IPersonaRepository;
import com.corhuila.electiva2.IService.IPersonaService;

@Service
public class PersonaService implements IPersonaService {

	@Autowired
	private IPersonaRepository repository;
	
	@Override
	public List<Persona> all() {
		return repository.findAll();
	}

	@Override
	public Optional<Persona> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Persona save(Persona persona) {
		persona.setFechaCreacion(LocalDateTime.now());
		return repository.save(persona);
	}

	@Override
	public void update(Persona persona, Long id) {
		//validar si existe.            
        Optional<Persona> op = repository.findById(id);		
        
        if(op.isEmpty()){
            System.out.println("Dato no encontrado");
        }else {
        	 //Crear nuevo objeto que va a contener los datos que se van actualizar
            Persona personaUpdate = op.get();
            personaUpdate.setNombre(persona.getNombre());
            personaUpdate.setDocumento(persona.getDocumento());
            personaUpdate.setCorreo(persona.getCorreo());
            personaUpdate.setFechaModificacion(LocalDateTime.now());
            
            //Actualizar el objeto
            repository.save(personaUpdate);
        }
        
        
	}

	@Override
	public void deletePhysical(Long id) {
		repository.deleteById(id);	
	}

	@Override
	public void deleteLogical(Long id) {
		//validar si existe.            
        Optional<Persona> op = repository.findById(id);		
        
        if(op.isEmpty()){
            System.out.println("Dato no encontrado");
        }else {
        	 //Crear nuevo objeto que va a contener los datos que se van actualizar
            Persona personaUpdate = op.get();
            personaUpdate.setFechaEliminacion(LocalDateTime.now());
            
            //Actualizar el objeto
            repository.save(personaUpdate);
        }		
	}	
}