package dao;

/**
 * Classe d'acces a la base de donnees
 * 
 * @author GUILLAUME GREARD - GROUPE 8 
 * @version 1.0
 * */
public class ConnectionDAO {
	/**
	 * Parametres de connexion a la base de donnees oracle
	 * URL, LOGIN et PASS sont des constantes
	 */
	final static String URL   = "jdbc:oracle:thin:@//oracle.esigelec.fr:1521/orcl.intranet.int";
	final static String LOGIN = "C##_G8_G1_APP";
	final static String PASS  = "APP_8_1";
	
	/**
	 * Constructor
	 * 
	 */
	public ConnectionDAO() {
		// chargement du pilote de bases de donnees
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}
	}
}