package fr.gestionnaire.annuaire;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import java.sql.ResultSet;

import java.sql.Connection;

public class JdbcTools {

	private String url;
	private String user;
	private String password;
	private String driverName;

	/**
	 * Constructor of JdbcTools
	 */
	public JdbcTools(){
//		setUrl("jdbc:mysql://localhost:3306/projetjee?autoReconnect=true&useSSL=false");
//		setUser("root");
//		setPassword("");
//		setDriverName("com.mysql.jdbc.Driver");
	}

	/**
	 * Return the url of the data base
	 * @return The url the link of the data base
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Set the url
	 * @param url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Return the user of the data base
	 * @return The user of the data base
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Set the user
	 * @param User of the data base
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Return the password of the data base
	 * @return The password of the data base
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the password
	 * @param password of the data base
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Return the name of the driver
	 * @return The name of the driver
	 */
	public String getDriverName() {
		return driverName;
	}

	/**
	 * Set the driver's name
	 * @param The new driver's name 
	 */
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	/**
	 * Load the driver
	 * @throws ClassNotFoundException
	 */
	public void init() throws ClassNotFoundException  {  
		loadDriver();
	}

	/**
	 * 
	 * @throws ClassNotFoundException
	 */
	public void loadDriver() throws ClassNotFoundException {
		Class.forName(driverName);
	}

	/**
	 * Create and return the connection at the data base
	 * @return
	 * @throws SQLException
	 */
	public Connection newConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}

	/**
	 * Close the connection of the data base
	 * @param c the current connection
	 * @throws SQLException
	 */
	public void quietClose(Connection c) throws SQLException { 
		if(c != null)
			c.close();
	}


	/**
	 * Execute the query
	 * @param query the query (SELECT / INSERT / INSERT INTO / DELETE)
	 * @param parameters the differents value of the colum
	 * @return a number of ligne modified
	 * @throws SQLException
	 */
	public int executeUpdate(String query, Object ... parameters)  throws SQLException  { 

		try (Connection conn = newConnection()){
			PreparedStatement st = conn.prepareStatement(query);
			prepareQuery(st, parameters);
			int nb=0;
			st.execute();
			ResultSet rs = st.getResultSet();
			
			if(rs==null){
				conn.close();
				return nb;
			}

			while(rs.next()){
				nb++;
			}	
			conn.close();
			return nb;
		} catch(MySQLIntegrityConstraintViolationException e){
			throw new MySQLIntegrityConstraintViolationException();
		}
		catch (SQLException e) {
			throw new SQLException();
		}
	}
	
	private void prepareQuery(PreparedStatement st, Object ... parameters) throws SQLException{
		for ( int i=0; i< parameters.length ; i++){
			if(parameters[i] instanceof String)
				st.setString(i+1, (String) parameters[i]);
			else if(parameters[i] instanceof Integer)
				st.setInt(i+1, (Integer) parameters[i]);
			else if(parameters[i] instanceof java.math.BigDecimal)
				st.setBigDecimal(i+1, (java.math.BigDecimal) parameters[i]);
		}
	}

	/**
	 * Test  the connection
	 * @return True if connection is established, else return false
	 * @throws SQLException
	 */
	//TODO Changer la fonction isConnect de façon a tester une vraie connexion  en paramètre ou en attribut
	public boolean isConnect() throws SQLException{
		if( newConnection() != null )
			return true; 
		return false;
	}
}
