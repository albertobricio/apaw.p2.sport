package es.upm.miw.apiArchitectureTheme.daos;

import java.util.List;

import es.upm.miw.apiArchitectureTheme.entities.*;

public interface UserDao extends GenericDao<User, Integer>{
	
    List<User> findAllWhoPracticeAnySport(String sportName);
}
