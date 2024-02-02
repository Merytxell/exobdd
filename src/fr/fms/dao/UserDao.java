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
		String str = "UPDATE T_Users SET Login=?, Password=? WHERE IdUser=?\";";
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
		String str = "DELETE FROM T_Users WHERE IdUser=?";
		try (PreparedStatement ps = connection.prepareStatement(str)) {
	
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
	public ArrayList<User> readAll() {
		ArrayList<User>users = new ArrayList<>();

		String str = "SELECT * FROM T_Users";
		try(PreparedStatement ps = connection.prepareStatement(str)){
			try (ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					int idUser = rs.getInt("IdUser");
					String login = rs.getString("Login");
					String password = rs.getString ("Password");
				

					User user = new User (idUser,login,password);

					users.add(user);


				}
			}
		}catch (SQLException e) {

		}

		return users;

	
	}
}