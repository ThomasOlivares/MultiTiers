package mail;

import java.util.ArrayList;

public class User {
	
	private String login;
	private String mdp;
	
	
	public User(String login, String mdp){
		this.login = login;
		this.mdp = mdp;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
}
