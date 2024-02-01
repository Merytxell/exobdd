package fr.fms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Properties;

public class ArticleDao  implements Dao <Article>{
	
	public interface DAO <T>{
	public Connection connection = BddConnection.getConnection();
	public void create (T obj);
	public T read (int id);
	public boolean update(T obj);
	public boolean delete(T obj);
	public ArrayList<T> readAll();

}
}
	
//ici on veut faire le lien entre notre appli et la BDD 
//Ajouter interface générique dites DAO -- ok
//qui doivent contenir les méthodes CRUD
// Capturer et relayer les exceptions avec des messages explicites (privilégier le try with ressources)
//tester dans programme principal