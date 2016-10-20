package es.upm.miw.apiArchitectureTheme.daos.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.upm.miw.apiArchitectureTheme.daos.UserDao;
import es.upm.miw.apiArchitectureTheme.entities.User;

public class UserDaoMemory extends GenericMemoryDao<User> implements UserDao{
	
	public UserDaoMemory() {
		this.setMap(new HashMap<Integer, User>());
	}

	@Override
	public List<String> findAllWhoPracticeAnySport(String sportName) {
		List<User> users = this.findAll();
		List<String> sportUsers = new ArrayList<>();
		for (User user : users) {
			if (user.getSport().getName() == sportName) {
				sportUsers.add(user.getNick());
			}
		}
		return sportUsers;
	}

	@Override
	protected Integer getId(User entity) {
		return entity.getId();
	}

	@Override
	protected void setId(User entity, Integer id) {
		entity.setId(id);
	}

}
