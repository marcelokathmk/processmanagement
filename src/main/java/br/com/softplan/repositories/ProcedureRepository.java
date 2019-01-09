package br.com.softplan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.softplan.domain.Procedure;

public interface ProcedureRepository extends JpaRepository<Procedure, Integer>{

	public List<Procedure> findByFeedbackPendentFalse();
	
	public List<Procedure> findByFeedbackPendentTrue();
}
