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

import com.corhuila.electiva2.Entity.ModuloRol;
import com.corhuila.electiva2.IService.IModuloRolService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/moduloRol")
public class ModuloRolController {
	
	@Autowired
	private IModuloRolService service;
	
	@GetMapping()
    public List<ModuloRol> all() {
        return service.all();
    }
	 
	 @GetMapping("{id}")
    public Optional<ModuloRol> findById(@PathVariable Long id) {
        return service.findById(id);
    }
	 
	 @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ModuloRol save(@RequestBody ModuloRol moduloRol) {
        return service.save(moduloRol);
    }
	 
	 @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@RequestBody ModuloRol moduloRol, @PathVariable Long id) {
        service.update(moduloRol, id);
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