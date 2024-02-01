package fr.fms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import fr.fms.entities.Article;

public class ArticleDao implements Dao <Article>{


	private Connection connection;

	public ArticleDao (Connection connection) {
		this.connection = connection;

	}
	@Override
	public boolean create(Article obj) {
		String str = "INSERT INTO T_Articles (Description, Brand, UnitaryPrice, IdCategory) VALUES (?,?,?,?);";
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1,obj.getDescription());
			ps.setString(2,obj.getBrand());
			ps.setDouble(3,obj.getPrice());
			ps.setInt(4,obj.getCategory());
			return ps.executeUpdate() ==1;
		}catch (SQLException e) {
			//Logger.getLogger(ArticleDao.class.getName()).severe("Problème SQL sur la création d'un article" + e.getMessage());
			return false;
		}
	}


	@Override
	public Article read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Article obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Article obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Article> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
