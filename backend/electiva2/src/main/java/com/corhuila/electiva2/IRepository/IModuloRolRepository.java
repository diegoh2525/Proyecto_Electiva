package com.corhuila.electiva2.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.corhuila.electiva2.Entity.ModuloRol;

@Repository
public interface IModuloRolRepository extends JpaRepository<ModuloRol, Long>{

}