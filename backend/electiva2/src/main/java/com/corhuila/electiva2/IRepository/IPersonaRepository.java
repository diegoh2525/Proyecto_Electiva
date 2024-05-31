package com.corhuila.electiva2.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.corhuila.electiva2.Entity.Persona;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long>{

}