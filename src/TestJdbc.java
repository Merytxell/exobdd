import java.util.ArrayList;
import java.util.Properties;

import fr.fms.dao.ArticleDao;
import fr.fms.dao.UserDao;
import fr.fms.entities.Article;
import fr.fms.entities.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbc {

	public static void main (String [] args) throws Exception {


		//Properties prop = CreateConfigFile.readPropertiesFile("src/config.properties");

		/*
		 * String url = prop.getProperty("db.url"); String login =
		 * prop.getProperty("db.login"); String password
		 * =prop.getProperty("db.password"); String driver =
		 * prop.getProperty("db.driver.class"); System.out.printf(url,login,password);
		 */

	
			//Article article = new Article ("Galaxy","Samsung",800);
			//ArticleDao articleDao = new ArticleDao();
			//articleDao.create(article);
			//Article article = articleDao.read(16);
			//articleDao.delete(1);
			
			//System.out.println(article);
			
			
			//test des users 
			User user = new User (2,"jojo","fms2026");
			UserDao userDao = new UserDao();
			userDao.create(user);
			
			System.out.println(user);
			
			//ArrayList<Article> articles = new ArrayList();
			//Create(new Article("MacbookPro","Apple", 5000));
			//Update(new Article(15,"MacbookPro", "Lime", 2000));
			//Delete(new Article (15,"MacbookPro", "Lime",2000));

			/*
			 * try { Class.forName(driver);//charge le pilote } catch
			 * (ClassNotFoundException e) { e.printStackTrace(); }
			 * 
			 * 
			 * try (Connection connection =
			 * DriverManager.getConnection(url,login,password)){//etabli la connexion String
			 * strSql = "SELECT*FROM T_Articles"; try ( Statement statement =
			 * connection.createStatement()){//exécute les requeêtes avec ou sans résultats
			 * resulset ? try (ResultSet rs = statement.executeQuery(strSql)){
			 * while(rs.next()){ int rsIDUser = rs.getInt(1); String rsDescription =
			 * rs.getString(2); String rsBrand = rs.getString(3); double rsPrice =
			 * rs.getDouble(4); //Article article = new Article
			 * (rs.getString(2),rs.getString(3), rs.getDouble(4)); articles.add((new
			 * Article(rsIDUser,rsDescription, rsBrand, rsPrice))); } } } for (Article a :
			 * articles) System.out.println(a.getIDUser() + " - " + a.getDescription()+
			 * " - "+ a.getBrand() + " - " + a.getPrice());
			 * 
			 * 
			 * } catch (SQLException e) { e.printStackTrace(); }
			 */

		}

		public static void Create (Article obj) {

			String url = "jdbc:mariadb://localhost:3306/Shop";
			String login = "root";
			String password = "fms2024";

			try (Connection connection = DriverManager.getConnection(url,login,password)){
				String str = "INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES (?,?,?);";
				try(PreparedStatement ps = connection.prepareStatement(str)){
					ps.setString(1,obj.getDescription());
					ps.setString(2,obj.getBrand());
					ps.setDouble(3,obj.getPrice());
					if (ps.executeUpdate()==1);
					System.out.println("insertion ok");

				}

			}catch(SQLException e) {
				e.printStackTrace();

			}
		}
		public static void Update(Article obj) {
			String url = "jdbc:mariadb://localhost:3306/Shop";
			String login = "root";
			String password = "fms2024";

			try (Connection connection = DriverManager.getConnection(url, login, password)) {
				String str = "UPDATE T_Articles SET Description=?, Brand=?, UnitaryPrice=? WHERE IdArticle=?";
				try (PreparedStatement ps = connection.prepareStatement(str)) {
					ps.setString(1, obj.getDescription());
					ps.setString(2, obj.getBrand());
					ps.setDouble(3, obj.getPrice());
					//ps.setInt(4, obj.getIDUser()); 

					if (ps.executeUpdate() == 1) {
						System.out.println("Mise à jour réussie");

					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public static void Delete(Article obj) {
			String url = "jdbc:mariadb://localhost:3306/Shop";
			String login = "root";
			String password = "fms2024";

			try (Connection connection = DriverManager.getConnection(url, login, password)) {
				String str = "DELETE FROM T_Articles WHERE IDArticle=?";
				try (PreparedStatement ps = connection.prepareStatement(str)) {
					//ps.setInt(1, obj.getIdArticle()); 

					int rowsAffected = ps.executeUpdate();
					if (rowsAffected > 0) {
						System.out.println("Suppression réussie");

					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


