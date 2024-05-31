package com.corhuila.electiva2.Service;

import com.corhuila.electiva2.Entity.Pedidos;
import com.corhuila.electiva2.IRepository.IBaseRepository;
import com.corhuila.electiva2.IRepository.IPedidosRepository;
import com.corhuila.electiva2.IService.IPedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidosService extends ABaseService<Pedidos> implements IPedidosService {

    @Override
    protected IBaseRepository<Pedidos, Long> getRepository() {
        return repository;
    }
    @Autowired
    private IPedidosRepository repository;
}