package user;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class User {
	
	private String login;
	private String mdp;
	private String mail;
	private long validity;
	
	
	public User(String login, String mdp, String mail){
		// we set the validty of the user cookie at now + 4 days
		long now = System.currentTimeMillis();
		this.validity = now + 4*24*3600*1000;
		
		this.login = login;
		this.mdp = mdp;
		this.mail = mail;
	}
	
	// we return if the user can steel access to the website using cookies or not
	public boolean isValid(){
		return System.currentTimeMillis() < validity;
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
