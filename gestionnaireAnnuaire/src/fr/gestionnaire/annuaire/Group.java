package fr.gestionnaire.annuaire;

/**
 * JavaBean of the group
 * @author Thomas
 *
 */
public class Group {
	
	private int idGroup=-1;
	private String nameGroup;

	/**
	 * Constructor of the group
	 */
	public Group(){}

	/**
	 * Return the id of the group
	 * @return id of the group
	 */
	public int getIdGroup() {
		return idGroup;
	}
	
	/**
	 * Set the group's id
	 * @param idGroup of the group
	 */
	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}
	
	/**
	 * Return the name of the group
	 * @return The group's name
	 */
	public String getNameGroup() {
		return nameGroup;
	}
	
	/**
	 * Set the group name
	 * @param nameGroup of the group
	 */
	public void setNameGroup(String nameGroup) {
		this.nameGroup = nameGroup;
	}
	
	public boolean equals(Group g){
		return 	idGroup == g.getIdGroup() && 
				nameGroup.equals(g.getNameGroup());
	}
}
