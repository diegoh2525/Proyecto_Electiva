package com.corhuila.electiva2.Controller;

import com.corhuila.electiva2.Entity.Pedidos;
import com.corhuila.electiva2.IService.IPedidosService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/pedidos")
public class PedidosController extends ABaseController<Pedidos, IPedidosService> {
    public PedidosController(IPedidosService service) {
        super(service, "Pedidos");
    }
}