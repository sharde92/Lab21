package co.grandcircus.coffeeshop;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.coffeeshop.dao.CoffeeDao;
import co.grandcircus.coffeeshop.dao.CoffeeShopDao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class CoffeeShopControllerHibernate {
	
	@Autowired
	private CoffeeShopDao coffeeshopdao;
	
	@Autowired
	private CoffeeDao coffeedao;
	
	
	@RequestMapping("/")
	public ModelAndView showHomePage() {
		ModelAndView mav = new ModelAndView("Index");
		List<Coffee> coffee = coffeedao.findAll();
		mav.addObject("coffee", coffee);
	return mav;

}
	
	
	@RequestMapping("/registration")
	public ModelAndView showCoffeeShopRegistration() {
		ModelAndView mav = new ModelAndView("CoffeeShopForm");
		
		return mav;
	}
	@RequestMapping("/coffee/create")
	public ModelAndView showCreateForm1() {
		// If there is only one model value to add, use this one-line shortcut. Equivalent to
		// ModelAndView mav = new ModelAndView("food-form");
		// mav.addObject("title", "Add a Food");
		return new ModelAndView("Index", "title", "Add an item");
	}
	
	@RequestMapping(value="/coffee/create", method=RequestMethod.POST)
	public ModelAndView submitCreateForm(Coffee coffee) {
		CoffeeDao.create(coffee);
		return new ModelAndView("redirect:/coffee");
	}
	
	// path variable required to identify which food we're editing
	@RequestMapping("/coffee/{id}/update")
	public ModelAndView showEditForm1(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("Index");
		mav.addObject("coffee", CoffeeDao.findById(id));
		mav.addObject("title", "Edit Coffee");
		return mav;
	}
	
	// same URL but different method
	@RequestMapping(value="/coffee/{id}/update", method=RequestMethod.POST)
	public ModelAndView submitEditForm(Coffee coffee, @PathVariable("id") Long id) {
		coffee.setId(id);
		CoffeeDao.update(coffee);
		return new ModelAndView("redirect:/coffee");
	}
	
	@RequestMapping("/coffee/{id}/delete")
	public ModelAndView delete1(@PathVariable("id") Long id) {
		CoffeeDao.delete(id);
		return new ModelAndView("redirect:/coffee");
	}
	
	@RequestMapping("/summary")
	public ModelAndView showsummary(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname,
			@RequestParam("age") String age,@RequestParam("password") String password, @RequestParam("email") String email,
			@RequestParam("phone_Number") String phonenumber) {
		ModelAndView mav = new ModelAndView("summary");
		mav.addObject("lastname", lastname);
		mav.addObject("firstname", firstname);
		mav.addObject("password", password);
		mav.addObject("age", age);
		mav.addObject("email", email);
		mav.addObject("phone_number", phonenumber);
		
		User user = new User();
		user.setLastname(lastname);
		user.setFirstname(firstname);
		user.setPassword(password);
		user.setAge(age);
		user.setEmail(email);
		user.setPhone_number(phonenumber);
		
		coffeeshopdao.create(user);

		return mav;
	}
	@RequestMapping("/user/create")
	public ModelAndView showCreateForm() {
		// If there is only one model value to add, use this one-line shortcut. Equivalent to
		// ModelAndView mav = new ModelAndView("food-form");
		// mav.addObject("title", "Add a Food");
		return new ModelAndView("CoffeeShopUserForm", "title", "Add a User");
	}
	
	@RequestMapping(value="/user/create", method=RequestMethod.POST)
	public ModelAndView submitCreateForm(User user) {
		CoffeeShopDao.create(user);
		return new ModelAndView("redirect:/user");
	}
	
	// path variable required to identify which food we're editing
	@RequestMapping("/user/{id}/update")
	public ModelAndView showEditForm(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("CoffeeShopUserForm");
		mav.addObject("user", CoffeeShopDao.findById(id));
		mav.addObject("title", "Edit User");
		return mav;
	}
	
	// same URL but different method
	@RequestMapping(value="/user/{id}/update", method=RequestMethod.POST)
	public ModelAndView submitEditForm(User user, @PathVariable("id") Long id) {
		user.setId(id);
		CoffeeShopDao.update(user);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/user/{id}/delete")
	public ModelAndView delete(@PathVariable("id") Long id) {
		CoffeeShopDao.delete(id);
		return new ModelAndView("redirect:/user");
	}
// A shortcut to add one item to ModelAndView is: return new ModelAndView("list", "rooms", leListOfRooms);

}

