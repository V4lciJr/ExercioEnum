package Entities;

public class Product {
	
	// Definição de atributos normais da classe
	private String name;
	private Double price;
	
	// Construtor padrão da classe
	public Product()
	{
		
	}
	
	// Construtor com atributos
	public Product(String name, Double price)
	{
		this.name = name;
		this.price = price;
	}
	
	// Getters e Setters padrão
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void setPrice(Double price)
	{
		this.price = price;
	}
}
