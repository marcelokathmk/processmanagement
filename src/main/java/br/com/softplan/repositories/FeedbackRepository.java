package br.com.softplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.softplan.domain.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer>{

}
