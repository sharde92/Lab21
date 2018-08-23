package co.grandcircus.coffeeshop;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CoffeeHibernate   {
	
	@Column(length=40)
	private String name;
	private String description;
	private float price;
	private int quantity;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	
	public CoffeeHibernate() {
		
	}
	
	
	
	public CoffeeHibernate(String name, String description, float price, int quantity, Long id) {
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
	
	@Override
	public String toString() {
		return "Coffee [ name=" + name + ", description=" + description + ", price=" + price + ",quantity=" + quantity + ", id=" + id + "]";
	}
	
	
	
	

}
