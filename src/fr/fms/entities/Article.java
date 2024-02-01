package fr.fms.entities;
public class Article {

	public int IDUser;
	public String Description; 
	public String Brand;
	public double Price;
	
	
	public Article (String Description, String Brand, double Price ) {
	
		this.Description=Description;
		this.Brand=Brand;
		this.Price=Price;
	
	}
	public Article (int IDUser,String Description, String Brand, double Price ) {
		
		this.IDUser=IDUser;
		this.Description=Description;
		this.Brand=Brand;
		this.Price=Price;
	
	}

	public int getIDUser() {
		return IDUser;
	}

	public void setUser(int IDuser) {
		IDUser = IDuser;
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
