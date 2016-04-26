/**
 * Handle the JDBC connection to the database
 * This class has package-level visibility: only DAO object may call it
 * @author Fulvio
 *
 */

package it.polito.tdp.country.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DBConnect {
	
	private static String url = "jdbc:mysql://localhost/countries?user=root&password=";

	/**
	 * Restituisce una nuova connessione, con i parametri a lui noti
	 * @return la nuova java.sql.Connection, oppure null se si verificano
	 * errori di connessione
	 */
	public static Connection getConnection() {
		Connection conn;
		try {
			conn = DriverManager.getConnection(url);
			return conn ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null ;
	}

}