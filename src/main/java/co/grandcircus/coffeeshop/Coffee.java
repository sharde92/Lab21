package co.grandcircus.coffeeshop;

import java.io.Serializable;

public class Coffee implements Serializable  {
	private String name;
	private String description;
	private float price;
	private int quantity;
	private Long id;
	
	private static final long serialVersionUID = 1L;
	
	public Coffee() {
		
	}
	
	
	
	public Coffee(String name, String description, float price, int quantity, Long id) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	

}
