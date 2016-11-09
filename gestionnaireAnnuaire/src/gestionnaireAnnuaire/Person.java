package gestionnaireAnnuaire;

public class Person {

	private int idPers, idGroup;
	private String firstName = null;
	private String lastName= null ;
	private String  mail = null;
	private String web = null;
	private String  naissance = null;
	private String password = null ;

	public Person(){}

	public int getId() {
		return idPers;
	}

	public void setId(int id) {
		this.idPers = id;
	}

	public int getIdGroup() {
		return idGroup;
	}

	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
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
