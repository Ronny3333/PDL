package dao;

import java.sql.*;
import model.*;

/**
 * Access class to the data contained in the DatePerso table
 * 
 * @author GUILLAUME GREARD 
 * @version 1.0
 * */
public class DatePersoDAO extends ConnectionDAO {

	public DatePersoDAO() {
		super();
	}
	
	public int add(DatePerso uneDate) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// Database connection
		try {

			// Connection attempt
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			
			String generatedColumns[] = { "IDDATE" };
			
			ps = con.prepareStatement("INSERT INTO DATE_2 (IDDATE, JOUR, MOIS, ANNEE) VALUES (DATE_2_SEQ.nextval, ?, ?, ?)", generatedColumns);
			ps.setInt(1, uneDate.getJour());
			ps.setInt(2, uneDate.getMois());
			ps.setInt(3, uneDate.getAnnee());
		
			
			// Query execution
			ps.executeUpdate();
			
			// Get the primary key using the "generatedColumns"
			try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    returnValue = generatedKeys.getInt(1);
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
			

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cet identifiant de fournisseur existe déjà. Ajout impossible !");
			else
				e.printStackTrace();
		} finally {
			// Close PreparedStatement and Connection
			
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}
}
