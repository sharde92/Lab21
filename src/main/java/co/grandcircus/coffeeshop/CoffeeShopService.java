package co.grandcircus.coffeeshop;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Component;

// The @Component annotation makes this is a singleton Spring Bean,
// created and managed by Spring. (Alternatively, could use @Service)
@Component
public class CoffeeShopService  {
	
	private static List<Coffee> list = new ArrayList<>();
	
	public CoffeeShopService() {
		list.add(new Coffee("Macchiato", "Espresso Cafe with Cream", "Rich and Bold."));
		list.add(new Coffee("Espresso shot", "highly caffeinated", "Dark and Strong."));
		list.add(new Coffee("Cappuccino", "Milk and Espresso", "Bold and rich."));
		list.add(new Coffee("Hot Chocolate", "Premium chocolate powder and milk", "Sweet and warm."));
		list.add(new Coffee("Lemon Loaf", "Sweet and moist", "sweet lemon icing on top."));
		list.add(new Coffee("Croissant","Pastry", "Flaky and Buttery."));
		
	}
	
	/**
	 * Get list of all foods.
	 */
	public static List<Coffee> getAllCoffee() {
		return list;
	}
	
	/**
	 * Get list of foods in a given category.
	 */
	public static List<Coffee> getCoffeeInCategory(String category) {
		List<Coffee> matches = new ArrayList<>();
		for(Coffee items : list) {
			if (items.getCategory().equalsIgnoreCase(category)) {
				matches.add(items);
			}
		}
		return matches;
	}
	
	/**
	 * Get list of food with name matching a keyword.
	 */
	public List<Coffee> getCoffeeByKeyword(String keyword) {
		keyword = keyword.toLowerCase();
		List<Coffee> matches = new ArrayList<>();
		for(Coffee items : list) {
			if (items.getFirstname().toLowerCase().contains(keyword)) {
				matches.add(items);
			}
		}
		return matches;
	}
	
	/**
	 * Get set of food categories.
	 */
	public Set<String> getCategories() {
		Set<String> categories = new TreeSet<>();
		for(Coffee items : list) {
			categories.add(items.getCategory());
		}
		return categories;
	}

	/**
	 * Add a food to the list
	 */
	public static void addCoffee(Coffee items) {
		list.add(items);
	}
}


