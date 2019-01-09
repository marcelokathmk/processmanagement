package br.com.softplan.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softplan.domain.Feedback;
import br.com.softplan.domain.Procedure;
import br.com.softplan.domain.User;
import br.com.softplan.domain.enums.UserType;
import br.com.softplan.repositories.FeedbackRepository;
import br.com.softplan.repositories.ProcedureRepository;
import br.com.softplan.repositories.UserRepository;
import br.com.softplan.security.CryptographySHA256;

@Service
public class DBService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProcedureRepository procedureRepository;
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	@Autowired
	private CryptographySHA256 crypto;
	
	public void instantiateDataBase() {
		User user1 = new User(UserType.ADMINITRADOR.getIdType(), "userAdmin", crypto.encode("123abc"), null);
		User user2 = new User(UserType.TRIADOR.getIdType(), "userTriador", crypto.encode("123qwerty"), user1);
		User user3 = new User(UserType.FINALIZADOR.getIdType(), "userFinalizador", crypto.encode("123qlkj"), user1);
		User user4 = new User(UserType.FINALIZADOR.getIdType(), "userFinalizadorDois", crypto.encode("123qlkj"), user1);
		
		userRepository.save(Arrays.asList(user1, user2, user3, user4));
		
		Procedure proc1 = new Procedure("Processo xyz", true, user2);
		proc1.getUsers().add(user2);
		proc1.getUsers().add(user3);
		Procedure proc2 = new Procedure("Processo abc", true, user2);
		proc2.getUsers().add(user3);
		Procedure proc3 = new Procedure("Processo tre", false, user2);
		proc3.getUsers().add(user3);
		Procedure proc4 = new Procedure("Processo qwerty", false, user2);
		proc4.getUsers().add(user3);
		
		procedureRepository.save(Arrays.asList(proc1, proc2, proc3, proc4));
		
		Feedback feed1 = new Feedback("parecer 1", proc3, user3);
		Feedback feed2 = new Feedback("parecer 2", proc4, user3);
		
		feedbackRepository.save(Arrays.asList(feed1, feed2));
	}
}
