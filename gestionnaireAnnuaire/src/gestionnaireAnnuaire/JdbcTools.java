package gestionnaireAnnuaire;


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

	public JdbcTools(){
		setUrl("jdbc:mysql://localhost:3306/projetjee?autoReconnect=true&useSSL=false");
		setUser("root");
		setPassword("");
		setDriverName("com.mysql.jdbc.Driver");
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public void init() throws ClassNotFoundException  {  
		loadDriver();
	}

	public void close() {  

	}

	public void loadDriver() throws ClassNotFoundException {
		Class.forName(driverName);
	}

	public Connection newConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}

	public void quietClose(Connection c) throws SQLException { 
		if(c != null)
			c.close();
	}


	public int executeUpdate(String query, Object ... parameters)  throws SQLException  { 

		try (Connection conn = newConnection()){
			// préparer l'instruction
			PreparedStatement st = conn.prepareStatement(query);

			for ( int i=0; i< parameters.length ; i++){
				if(parameters[i] instanceof String)
					st.setString(i+1, (String) parameters[i]);
				else if(parameters[i] instanceof Integer)
					st.setInt(i+1, (Integer) parameters[i]);
				else if(parameters[i] instanceof java.math.BigDecimal)
					st.setBigDecimal(i+1, (java.math.BigDecimal) parameters[i]);
			}
			int nb=0;
			// exécuter l'instruction
			st.execute();
			ResultSet rs = st.getResultSet();
			if(rs==null){
				conn.close();
				return nb;
			}

			while(rs.next()){
				nb++;
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5));
			}	
			conn.close();
			return nb;
		} catch(MySQLIntegrityConstraintViolationException e){
			e.printStackTrace();
			throw new MySQLIntegrityConstraintViolationException();
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException();
		}
	}

	public boolean isConnect() throws SQLException{
		if( newConnection() != null )
			return true;
		return false;
	}
}
