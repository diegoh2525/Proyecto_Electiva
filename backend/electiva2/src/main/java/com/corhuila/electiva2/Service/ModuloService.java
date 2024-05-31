package com.corhuila.electiva2.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.electiva2.Entity.Modulo;
import com.corhuila.electiva2.IRepository.IModuloRepository;
import com.corhuila.electiva2.IService.IModuloService;

@Service
public class ModuloService implements IModuloService {

	@Autowired
	private IModuloRepository repository;
	
	@Override
	public List<Modulo> all() {
		return repository.findAll();
	}

	@Override
	public Optional<Modulo> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Modulo save(Modulo modulo) {
		modulo.setFechaCreacion(LocalDateTime.now());
		return repository.save(modulo);
	}

	@Override
	public void update(Modulo modulo, Long id) {
		//validar si existe.            
        Optional<Modulo> op = repository.findById(id);		
        
        if(op.isEmpty()){
            System.out.println("Dato no encontrado");
        }else {
        	 //Crear nuevo objeto que va a contener los datos que se van actualizar
            Modulo moduloUpdate = op.get();
            moduloUpdate.setNombre(modulo.getNombre());
            moduloUpdate.setCodigo(modulo.getCodigo());
            moduloUpdate.setDescripcion(modulo.getDescripcion());
            moduloUpdate.setRuta(modulo.getRuta());
            moduloUpdate.setFechaModificacion(LocalDateTime.now());
            
            //Actualizar el objeto
            repository.save(moduloUpdate);
        }
        
        
	}

	@Override
	public void deletePhysical(Long id) {
		repository.deleteById(id);	
	}

	@Override
	public void deleteLogical(Long id) {
		//validar si existe.            
        Optional<Modulo> op = repository.findById(id);		
        
        if(op.isEmpty()){
            System.out.println("Dato no encontrado");
        }else {
        	 //Crear nuevo objeto que va a contener los datos que se van actualizar
            Modulo moduloUpdate = op.get();
            moduloUpdate.setFechaEliminacion(LocalDateTime.now());
            
            //Actualizar el objeto
            repository.save(moduloUpdate);
        }		
	}	
}