package com.corhuila.electiva2.IRepository;

import com.corhuila.electiva2.Entity.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpleadosRepository extends IBaseRepository<Empleados, Long> {
}