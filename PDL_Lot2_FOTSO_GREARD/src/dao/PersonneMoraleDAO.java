package dao;

import java.sql.*;
import model.*;

/**
 * Access class to the data contained in the PersonneMorale table
 * 
 * @author GUILLAUME GREARD 
 * @version 1.0
 * */
public class PersonneMoraleDAO extends ConnectionDAO {

	public PersonneMoraleDAO() {
		super();
	}
	
	public int add(PersonneMorale unePersonneMorale, int fk_pk_Birthdate) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// Database connection
		try {

			// Connection attempt
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			
			String generatedColumns[] = { "IDPERSONNEMORALE" };
			
			ps = con.prepareStatement("INSERT INTO PERSONNEMORALE_2 (IDPERSONNEMORALE, NOM, PRENOM, IDDATENAISSANCE) VALUES (PERSONNEMORALE_2_SEQ.nextval, ?, ?, ?)", generatedColumns);
			ps.setString(1, unePersonneMorale.getNom());
			ps.setString(2, unePersonneMorale.getPrenom());
			ps.setInt(3, fk_pk_Birthdate);
		
			
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
