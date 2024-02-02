package fr.fms.entities;

import fr.fms.dao.ArticleDao;

public class Article {

	public int idArticle;
	public String Description; 
	public String Brand;
	public double Price;


	public Article (String Description, String Brand, double Price ) {

		this.Description=Description;
		this.Brand=Brand;
		this.Price=Price;

	}

	public Article(int idArticle, String description, String brand, double price) {
		super();
		this.idArticle = idArticle;
		Description = description;
		Brand = brand;
		Price = price;
	}


	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", Description=" + Description + ", Brand=" + Brand + ", Price="
				+ Price + "]";
	}



	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}





}






