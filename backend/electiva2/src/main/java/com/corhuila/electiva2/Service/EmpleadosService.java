package com.corhuila.electiva2.Service;

import com.corhuila.electiva2.Entity.Empleados;
import com.corhuila.electiva2.IRepository.IBaseRepository;
import com.corhuila.electiva2.IRepository.IEmpleadosRepository;
import com.corhuila.electiva2.IService.IEmpleadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadosService extends ABaseService<Empleados> implements IEmpleadosService {

    @Override
    protected IBaseRepository<Empleados, Long> getRepository() {
        return repository;
    }
    @Autowired
    private IEmpleadosRepository repository;
}