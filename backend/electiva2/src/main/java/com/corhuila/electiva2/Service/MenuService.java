package com.corhuila.electiva2.Service;

import com.corhuila.electiva2.Entity.Menu;
import com.corhuila.electiva2.IRepository.IBaseRepository;
import com.corhuila.electiva2.IRepository.IMenuRepository;
import com.corhuila.electiva2.IService.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService extends ABaseService<Menu> implements IMenuService {

    @Override
    protected IBaseRepository<Menu, Long> getRepository() {
        return repository;
    }
    @Autowired
    private IMenuRepository repository;
}