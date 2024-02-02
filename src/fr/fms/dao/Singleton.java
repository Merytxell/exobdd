package fr.fms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {


	private static Singleton instance;
	public String value;
	private Connection connection;

	private Connection Singleton() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/Shop","root","fms2024");
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

//méthode qui sert à vérifier qu'il n'y a qu'une seule instance de la classe Singleton dans l'application
	//ça empêche les conflits 
	public static Singleton getInstance() {
		//vérifie si l'onstance de la classe a déjà été créé
		if (instance == null) {
			instance = new Singleton();
		}
		//renvoie l'existance de l'instance.
		return instance;

	}
	public Connection getConnection() {
		return connection;
	}
//ferme la connection
	public void closeConnection() {
		try {
			//vérifie que la connexion n'est pas nulle et que la connection n'est pas fermée
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
// maintenant faut connecter les dao avec ce pattern

