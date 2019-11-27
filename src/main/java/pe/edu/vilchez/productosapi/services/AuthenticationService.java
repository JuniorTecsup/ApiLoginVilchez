package pe.edu.vilchez.productosapi.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import pe.edu.vilchez.productosapi.models.Usuario;
import pe.edu.vilchez.productosapi.repositories.AuthenticationRepository;


@Service
public class AuthenticationService {

private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);
	
	@Autowired
    private AuthenticationRepository authenticationRepository;
	
	public Usuario login(String username, String password) throws BadCredentialsException {
		logger.info("login("+username+", "+password+")");
        return authenticationRepository.login(username, password);
    }
	
	public Usuario findByUsername(String username) throws EmptyResultDataAccessException{
		logger.info("findByUsername("+username+")");
		return authenticationRepository.findByUsername(username);
	}

}
