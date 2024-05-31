package com.corhuila.electiva2.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.electiva2.Entity.Usuario;
import com.corhuila.electiva2.IRepository.IUsuarioRepository;
import com.corhuila.electiva2.IService.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private IUsuarioRepository repository;
	
	@Override
	public List<Usuario> all() {
		return repository.findAll();
	}

	@Override
	public Optional<Usuario> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Usuario save(Usuario usuario) {
		usuario.setFechaCreacion(LocalDateTime.now());
		return repository.save(usuario);
	}

	@Override
	public void update(Usuario usuario, Long id) {
		//validar si existe.            
        Optional<Usuario> op = repository.findById(id);		
        
        if(op.isEmpty()){
            System.out.println("Dato no encontrado");
        }else {
        	 //Crear nuevo objeto que va a contener los datos que se van actualizar
            Usuario usuarioUpdate = op.get();
            usuarioUpdate.setUsuario(usuario.getUsuario());
            usuarioUpdate.setContrasenia(usuario.getContrasenia());
            usuarioUpdate.setPersonaId(usuario.getPersonaId());
            usuarioUpdate.setFechaModificacion(LocalDateTime.now());
            
            //Actualizar el objeto
            repository.save(usuarioUpdate);
        }
        
        
	}

	@Override
	public void deletePhysical(Long id) {
		repository.deleteById(id);	
	}

	@Override
	public void deleteLogical(Long id) {
		//validar si existe.            
        Optional<Usuario> op = repository.findById(id);		
        
        if(op.isEmpty()){
            System.out.println("Dato no encontrado");
        }else {
        	 //Crear nuevo objeto que va a contener los datos que se van actualizar
            Usuario usuarioUpdate = op.get();
            usuarioUpdate.setFechaEliminacion(LocalDateTime.now());
            
            //Actualizar el objeto
            repository.save(usuarioUpdate);
        }		
	}	
}