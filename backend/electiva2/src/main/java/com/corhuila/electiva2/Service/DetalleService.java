package com.corhuila.electiva2.Service;

import com.corhuila.electiva2.Entity.Detalle;
import com.corhuila.electiva2.IRepository.IBaseRepository;
import com.corhuila.electiva2.IRepository.IDetalleRepository;
import com.corhuila.electiva2.IService.IDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleService extends ABaseService<Detalle> implements IDetalleService {

    @Override
    protected IBaseRepository<Detalle, Long> getRepository() {
        return repository;
    }
    @Autowired
    private IDetalleRepository repository;
}