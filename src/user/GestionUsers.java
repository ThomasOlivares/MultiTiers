package user;

import java.util.ArrayList;

public class GestionUsers {
	
	private static ArrayList<User> users;
	
	public GestionUsers(){
		super();
	}
	
	public static ArrayList<User> newInstance(){
    	if (users==null)
    	{
    		users = new ArrayList<User>();
	    	users.add(new User("bob", "passe"));//to test right now
    	}
	    return users;       
	}
	
	public boolean isUser(String login, String mdp)
	{
		for (User user : users){
			if (user.getLogin().equals(login) && 
				user.getMdp().equals(mdp))
			{
				return true;
			}
		}
		return false;
	}
}
