package co.grandcircus.coffeeshop;


import org.springframework.stereotype.Controller;

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
public class CoffeeShopController {
	
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
//	@RequestMapping("/items")
////	public ModelAndView listCoffee(@RequestParam(value="category", required=false) String category) {
////		ModelAndView mav = new ModelAndView("list-items");
////		if (category != null && !category.isEmpty()) {
////			mav.addObject("items", CoffeeShopService.getCoffeeInCategory(category));
////			mav.addObject("category", category);
////		} else {
////			mav.addObject("items", CoffeeShopService.getAllCoffee());
////		}
////		return mav;
////	}
//	
//	@RequestMapping("/add-items")
//	public ModelAndView showCofeeForm() {
//		return new ModelAndView("items-form");
//	}
//	
//	// Two controllers handling the same URL path, but this one handles the POST
//	// which is triggered when the form submits.
//	@RequestMapping(value="/add-items", method=RequestMethod.POST)
//	// When a POJO (Java Bean) is provided as a parameter, Spring MVC automatically
//	// fills in all the properties from the request params!
//	public ModelAndView submitCoffeeForm(User items) {
//		CoffeeShopService.addCoffee(items);
//		// using a view name that starts with "redirect:" skips the JSP and instead
//		// redirects the browser to the given URL, effectively redirecting to another
//		// controller.
//		return new ModelAndView("redirect:/items");
//	}
}

