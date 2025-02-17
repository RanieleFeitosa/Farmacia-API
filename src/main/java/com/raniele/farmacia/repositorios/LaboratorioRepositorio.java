package com.raniele.farmacia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raniele.farmacia.entidades.Laboratorio;

@Repository
public interface LaboratorioRepositorio extends JpaRepository<Laboratorio, String> {

}
