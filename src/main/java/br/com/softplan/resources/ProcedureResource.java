package br.com.softplan.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.com.softplan.domain.Procedure;
import br.com.softplan.services.ProcedureService;

@RestController
@RequestMapping(value = "/procedure")
public class ProcedureResource {

	@Autowired
	private ProcedureService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Procedure>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@RequestMapping(value = "/pendent", method = RequestMethod.GET)
	public ResponseEntity<List<Procedure>> findByFeedbackPendentTrue(){
		return ResponseEntity.ok().body(service.findByFeedbackPendentTrue());
	}
	
	@RequestMapping(value = "/notPendent", method = RequestMethod.GET)
	public ResponseEntity<List<Procedure>> findByFeedbackPendentFalse(){
		return ResponseEntity.ok().body(service.findByFeedbackPendentFalse());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Procedure> find(@PathVariable Integer id){
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> saveProcedure(@Valid @RequestBody Procedure procedure){
		procedure = service.save(procedure);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(procedure.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
