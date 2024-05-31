package com.corhuila.electiva2.Controller;

import com.corhuila.electiva2.Entity.Menu;
import com.corhuila.electiva2.IService.IMenuService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/menu")
public class MenuController extends ABaseController<Menu, IMenuService> {
    public MenuController(IMenuService service) {
        super(service, "Menu");
    }
}