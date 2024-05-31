package com.corhuila.electiva2.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.electiva2.Entity.ModuloVista;
import com.corhuila.electiva2.IRepository.IModuloVistaRepository;
import com.corhuila.electiva2.IService.IModuloVistaService;

@Service
public class ModuloVistaService implements IModuloVistaService {

	@Autowired
	private IModuloVistaRepository repository;
	
	@Override
	public List<ModuloVista> all() {
		return repository.findAll();
	}

	@Override
	public Optional<ModuloVista> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public ModuloVista save(ModuloVista moduloVista) {
		moduloVista.setFechaCreacion(LocalDateTime.now());
		return repository.save(moduloVista);
	}

	@Override
	public void update(ModuloVista moduloVista, Long id) {
		//validar si existe.            
        Optional<ModuloVista> op = repository.findById(id);		
        
        if(op.isEmpty()){
            System.out.println("Dato no encontrado");
        }else {
        	 //Crear nuevo objeto que va a contener los datos que se van actualizar
            ModuloVista moduloVistaUpdate = op.get();
            moduloVistaUpdate.setModuloId(moduloVista.getModuloId());
            moduloVistaUpdate.setVistaId(moduloVista.getVistaId());
            moduloVistaUpdate.setFechaModificacion(LocalDateTime.now());
            
            //Actualizar el objeto
            repository.save(moduloVistaUpdate);
        }
        
        
	}

	@Override
	public void deletePhysical(Long id) {
		repository.deleteById(id);	
	}

	@Override
	public void deleteLogical(Long id) {
		//validar si existe.            
        Optional<ModuloVista> op = repository.findById(id);		
        
        if(op.isEmpty()){
            System.out.println("Dato no encontrado");
        }else {
        	 //Crear nuevo objeto que va a contener los datos que se van actualizar
            ModuloVista moduloVistaUpdate = op.get();
            moduloVistaUpdate.setFechaEliminacion(LocalDateTime.now());
            
            //Actualizar el objeto
            repository.save(moduloVistaUpdate);
        }		
	}	
}