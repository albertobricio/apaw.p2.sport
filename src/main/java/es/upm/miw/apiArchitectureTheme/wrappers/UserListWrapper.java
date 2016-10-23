package es.upm.miw.apiArchitectureTheme.wrappers;

import java.util.ArrayList;
import java.util.List;

public class UserListWrapper {
	
	List<UserWrapper> userList;
	
	public UserListWrapper()
	{
		userList=new ArrayList<>();
	}
	
	public List<UserWrapper> getUserList()
	{
		return userList;
	}
	
	public void addUserWrapper (UserWrapper userWrapper)
	{
		userList.add(userWrapper);
	}
	
	public String toString() {
		String result = "{\"userList\":[ ";
		for (UserWrapper userWrapper : userList) {
			result += userWrapper.toString() + ",";
		}
		return result.substring(0, result.length() - 1) + "]}";
	}

}
