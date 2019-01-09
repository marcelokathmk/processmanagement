package br.com.softplan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softplan.domain.Feedback;
import br.com.softplan.repositories.FeedbackRepository;

@Service
public class FeedbackService {

	@Autowired
	private FeedbackRepository repository;
	
	public List<Feedback> findAll(){
		return repository.findAll();
	}
	
	public Feedback findById(Integer id) {
		return repository.findOne(id);
	}
	
	public void save(Feedback feedback) {
		repository.save(feedback);
	}
}
