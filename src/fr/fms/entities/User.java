package fr.fms.entities;

public class User {

	public int idUser;
	public String login;
	public String password;
	
	
	
	public User(int idUser, String login, String password) {
		super();
		this.idUser = idUser;
		this.login = login;
		this.password = password;
	}



	public int getIdUser() {
		return idUser;
	}



	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
