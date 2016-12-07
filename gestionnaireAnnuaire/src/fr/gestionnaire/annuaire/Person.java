package fr.gestionnaire.annuaire;

/**
 * JavaBean of the Person
 * @author Thomas
 *
 */
public class Person {

	private int idPers=-1;
	private int idGroup=-1;
	private String firstName = null;
	private String lastName= null ;
	private String  mail = null;
	private String web = null;
	private String  naissance = null;
	private String password = null ;

	/**
	 * Constuctor of the person
	 */
	public Person(){}


	/**
	 * Set the id of the person
	 * @param id of the person
	 */
	public void setIdPers(int idPers) {
		this.idPers = idPers;
	}

	/**
	 * Return the id of the person
	 * @return the id of the person
	 */
	public int getIdPers() {
		return idPers;
	}


	/**
	 * Return the id of the group
	 * @return the id of the group
	 */
	public int getIdGroup() {
		return idGroup;
	}

	/**
	 * Set the id of the group
	 * @param idGroup of the goup
	 */
	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}

	/**
	 * Return the first name of the person
	 * @return the first name of the person
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Set the first name of the person
	 * @param firstName the first name of the person
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Return the last name of the person
	 * @return the last name of the person
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Set the last name of the person
	 * @param lastName the last name of the person
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Return the mail of the person
	 * @return
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * Set the mail of the person
	 * @param mail of the mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * Return the web site of the person
	 * @return the web site of the person
	 */
	public String getWeb() {
		return web;
	}

	/**
	 * Set the web site of the person
	 * @param web the web site of the person
	 */
	public void setWeb(String web) {
		this.web = web;
	}

	/**
	 * Return the password of the person
	 * @return the password of the person
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the passord of the person
	 * @param password of the person
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Return the date of birth of the person
	 * @return the date of birth of the person
	 */
	public String getNaissance() {
		return naissance;
	}

	/**
	 * Set the date of birth of the person
	 * @param naissance the date of birth of the person
	 */
	public void setNaissance(String naissance) {
		this.naissance = naissance;
	}

	public boolean equals(Person p){
		return idPers == p.getIdPers() && 
				idGroup == p.getIdGroup() && 
				firstName.equals(p.getFirstName()) &&
				lastName.equals(p.getLastName()) && 
				mail.equals(p.getMail()) &&
				web.equals(p.getWeb()) &&
				naissance.equals(p.getNaissance()) &&
				password.equals(p.getPassword());
	}
	
	public String toString(){
		return "Id : "+idPers +
				" - Group : "+idGroup +
				" - "+ firstName +
				" - "+ lastName +
				" - "+ mail + 
				" - "+ web +
				" - "+naissance +
				" - "+password;
	}
}
