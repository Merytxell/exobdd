package fr.fms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {


	private static volatile Singleton instance;
	public String data;

	private Singleton(String data) {
		this.data =data;
		
	}
	
	public static Singleton getInstance (String data) {
		
		Singleton result = instance;
		if (instance == null) {
		synchronized (Singleton.class) {
			result = instance;
			if (instance == null) {
				instance = new Singleton(data);
		
		}
	}
}
		return instance;
		
	} 
}
	
//le singleton permet le multi threading 
// retourne les instances existantes si elles ont déjà été créés
// doit être utilisé quand une classe peut avoir une seule instance disponible
// rend indisponible la création d'objetcs de classe sauf pour les méthodes static
	



