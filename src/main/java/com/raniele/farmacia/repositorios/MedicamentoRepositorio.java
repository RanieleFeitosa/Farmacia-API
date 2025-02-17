package com.raniele.farmacia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raniele.farmacia.entidades.Medicamento;

@Repository
public interface MedicamentoRepositorio extends JpaRepository<Medicamento, Long> {

}
