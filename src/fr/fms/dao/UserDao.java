package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.fms.entities.Article;
import fr.fms.entities.User;

public class UserDao implements Dao<User>{

	@Override
	public boolean create(User obj) {
		String str = "INSERT INTO T_Users (idUser,login,password) VALUES (?,?,?);";
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setInt(1,obj.getIdUser());
			ps.setString(2,obj.getLogin());
			ps.setString(3,obj.getPassword());
			return ps.executeUpdate() ==1;
		}catch (SQLException e) {
			//Logger.getLogger(ArticleDao.class.getName()).severe("Problème SQL sur la création d'un article" + e.getMessage());
			return false;

	}
}

	@Override
	public User read(int id) {
		String str = "SELECT * FROM T_User WHERE IdUser = ?";
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setInt(1,id);

			try (ResultSet rs = ps.executeQuery()){
				if (rs.next()) {
					int rsIdUser = rs.getInt("IdUser");
					String rsLogin = rs.getString("Login");
					String rsPassword = rs.getString("Password");

					return new User (rsIdUser, rsLogin, rsPassword);
				}

			}
		}catch (SQLException e) {

		}
		return null;
	}


	@Override
	public boolean update(User obj) {
		String str = "UPDATE T_USERS SET Login=?, Password=? WHERE IdUser=?\";";
		try (PreparedStatement ps = connection.prepareStatement(str)) {
			ps.setString(1, obj.getLogin());
			ps.setString(2, obj.getPassword());
		
			return ps.executeUpdate() >0;
		}catch (SQLException e) {
			return false;
		}

	}

	@Override
	public boolean delete(User obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<User> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
