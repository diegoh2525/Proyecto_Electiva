package com.corhuila.electiva2.Controller;

import com.corhuila.electiva2.Entity.Empleados;
import com.corhuila.electiva2.IService.IEmpleadosService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/empleados")
public class EmpleadosController extends ABaseController<Empleados, IEmpleadosService> {
    public EmpleadosController(IEmpleadosService service) {
        super(service, "Empleados");
    }
}