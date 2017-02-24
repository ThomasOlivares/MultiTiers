package user;

import java.util.ArrayList;

public class User {
	
	private String login;
	private String mdp;
	private String mail;
	
	
	public User(String login, String mdp, String mail){
		this.login = login;
		this.mdp = mdp;
		this.mail = mail;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
}
