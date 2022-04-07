package dao;

import java.sql.*;
import model.*;

public class BateauDAO extends ConnectionDAO {
	
	public BateauDAO() {
		super();
	}

	public int add(Bateau unBateau) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// Database connection
		try {

			// Connection attempt
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			
			String generatedColumns[] = { "IDBATEAU" };
			
			ps = con.prepareStatement("INSERT INTO BATEAU_2 (IDBATEAU, NOM, TAILLE, PAVILLON) VALUES (BATEAU_2_SEQ.nextval, ?, ?, ?)", generatedColumns);
			ps.setString(1, unBateau.getNom());
			ps.setDouble(2, unBateau.getTaille());
			ps.setString(2, unBateau.getPavillon());
			
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
