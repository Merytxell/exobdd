package fr.fms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import fr.fms.entities.Article;

public class ArticleDao implements Dao <Article>{

	/*
	 * private Connection connection;
	 * 
	 * public ArticleDao (Connection connection) { this.connection = connection;
	 * 
	 * }
	 */
	@Override
	public boolean create(Article obj) {
		String str = "INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES (?,?,?);";
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1,obj.getDescription());
			ps.setString(2,obj.getBrand());
			ps.setDouble(3,obj.getPrice());
			//ps.setInt(4,obj.getCategory());
			return ps.executeUpdate() ==1;
		}catch (SQLException e) {
			//Logger.getLogger(ArticleDao.class.getName()).severe("Problème SQL sur la création d'un article" + e.getMessage());
			return false;
		}
	}


	@Override
	public Article read(int id) {
		String str = "SELECT * FROM T_Articles WHERE IdArticle = ?";
		try (PreparedStatement ps = connection.prepareStatement(str)){///pourquoi ?
			ps.setInt(1,id);

			try (ResultSet rs = ps.executeQuery()){///pourquoi ?
				if (rs.next()) {
					int rsIdArticle = rs.getInt("IdArticle");
					String rsDescription = rs.getString("Description");
					String rsBrand = rs.getString("Brand");
					double rsPrice = rs.getDouble("UnitaryPrice");
					//int rsCategory = rs.getInt("IdCategory");


					return new Article (rsIdArticle,rsDescription, rsBrand, rsPrice);
				}

			}
		}catch (SQLException e) {

		}
		return null;
	}

	@Override
	public boolean update(Article obj) {
		String str = "UPDATET_Articles SET Description=?, Brand=?, UnitaryPrice=? WHERE IdArticle=?\";";
		try (PreparedStatement ps = connection.prepareStatement(str)) {
			ps.setString(1, obj.getDescription());
			ps.setString(2, obj.getBrand());
			ps.setDouble(3, obj.getPrice());
			//ps.setInt (4, obj.getI());

			//on vérifie que la maj affecte une ligne et si oui tout est ok
			return ps.executeUpdate() >0;
		}catch (SQLException e) {
			return false;

		}
	}

	@Override
	public boolean delete(Article obj) {
		String str = "DELETE FROM T_Articles WHERE IdArticle=?";
		try (PreparedStatement ps = connection.prepareStatement(str)) {
			//ps.setInt(1, obj.getIdArticle()); 

			int rowsAffected = ps.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Suppression réussie");
				return true;

			}else {
				System.out.println("aucune ligne supprimée");
			}
		}catch (SQLException e) {

		}
		return false;
	}

	@Override
	public ArrayList<Article> readAll() {

		ArrayList<Article>articles = new ArrayList<>();

		String str = "SELECT * FROM T_Articles";
		//ici deux try with ressources
		try(PreparedStatement ps = connection.prepareStatement(str)){
			try (ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					int id = rs.getInt("IDArticle");
					String description = rs.getString("Description");
					String brand = rs.getString ("Brand");
					double price = rs.getDouble("UnitaryPrice");

					Article article = new Article (id,description,brand,price);

					articles.add(article);


				}
			}
		}catch (SQLException e) {

		}

		return articles;
	}

}


