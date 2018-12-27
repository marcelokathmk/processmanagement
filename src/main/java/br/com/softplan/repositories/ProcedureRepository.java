package br.com.softplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.softplan.domain.Procedure;

public interface ProcedureRepository extends JpaRepository<Procedure, Integer>{

}
