package com.corhuila.electiva2.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.corhuila.electiva2.Entity.UsuarioRol;
import com.corhuila.electiva2.IService.IUsuarioRolService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/usuarioRol")
public class UsuarioRolController {
	
	@Autowired
	private IUsuarioRolService service;
	
	@GetMapping()
    public List<UsuarioRol> all() {
        return service.all();
    }
	 
	 @GetMapping("{id}")
    public Optional<UsuarioRol> findById(@PathVariable Long id) {
        return service.findById(id);
    }
	 
	 @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public UsuarioRol save(@RequestBody UsuarioRol usuarioRol) {
        return service.save(usuarioRol);
    }
	 
	 @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@RequestBody UsuarioRol usuarioRol, @PathVariable Long id) {
        service.update(usuarioRol, id);
    }
	 
	 @PutMapping("deleteLogical/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteLogical(@PathVariable Long id) {
        service.deleteLogical(id);
    }
	 
	 @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletePhysical(@PathVariable Long id) {
        service.deletePhysical(id);
    }

}