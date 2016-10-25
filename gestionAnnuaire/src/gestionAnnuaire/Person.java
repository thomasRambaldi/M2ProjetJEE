package gestionAnnuaire;

public class Person {
	private int idPers;
	private String firstName, lastName, mail, web, naissance, password;
	

	public Person(){}
	
	public int getId() {
		return idPers;
	}

	public void setId(int id) {
		this.idPers = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getPassword() {
		return password;
	}

	public String getNaissance() {
		return naissance;
	}

	public void setNaissance(String naissance) {
		this.naissance = naissance;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	
}
