package com.corhuila.electiva2.Controller;

import com.corhuila.electiva2.Entity.Detalle;
import com.corhuila.electiva2.IService.IDetalleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/detalle")
public class DetalleController extends ABaseController<Detalle, IDetalleService> {
    public DetalleController(IDetalleService service) {
        super(service, "Detalle");
    }
}