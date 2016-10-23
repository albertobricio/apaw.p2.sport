package es.upm.miw.apiArchitectureTheme.daos.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.upm.miw.apiArchitectureTheme.daos.UserDao;
import es.upm.miw.apiArchitectureTheme.entities.Sport;
import es.upm.miw.apiArchitectureTheme.entities.User;

public class UserDaoMemory extends GenericMemoryDao<User> implements UserDao{
	
	public UserDaoMemory() {
		this.setMap(new HashMap<Integer, User>());
	}

	@Override
	public List<User> findAllWhoPracticeAnySport(String sportName) {
		List<User> users = this.findAll();
		List<User> sportUsers = new ArrayList<User>();
		for (User user : users) {
			List<Sport> sportList=user.getSportList();
			for(Sport sport : sportList)
			{
				if(sport.getName().equals(sportName))
				{
					sportUsers.add(user);
					break;
				}
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

	@Override
	public void putSport(String nick, String sportName) {
		List<User> users = this.findAll();
		Sport newSport = new Sport(sportName);
		for (User user : users)
		{
			if(user.getNick().equals(nick))
			{
				user.putSportinList(newSport);
				break;
			}
		}
	}

}
