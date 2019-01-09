package br.com.softplan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.softplan.domain.Procedure;
import br.com.softplan.repositories.ProcedureRepository;
import br.com.softplan.services.exception.ObjectNotFoundException;

@Service
public class ProcedureService {

	@Autowired
	private ProcedureRepository repository;
	
	public List<Procedure> findAll(){
		return repository.findAll();
	}
	
	public Procedure findById(Integer id) {
		Procedure procedure = repository.findOne(id); 
		if	(procedure == null) {
			throw new ObjectNotFoundException("Processo não encontrado! id: "+ id);
		}
		return procedure;
	}
	
	public List<Procedure> findByFeedbackPendentFalse(){
		return repository.findByFeedbackPendentFalse();
	}
	
	public List<Procedure> findByFeedbackPendentTrue(){
		return repository.findByFeedbackPendentTrue();
	}
	
	public Procedure save(Procedure procedure) {
		return repository.save(procedure);
	}
}
