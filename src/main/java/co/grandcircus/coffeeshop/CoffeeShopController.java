package co.grandcircus.coffeeshop;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class CoffeeShopController {
	
	@RequestMapping("/")
	public ModelAndView showHomePage() {
		ModelAndView mav = new ModelAndView("userIndex");
		
		return mav;

}
	
	
	@RequestMapping("/registration")
	public ModelAndView showCoffeeShopRegistration(@RequestParam("Name") String name ) {
		ModelAndView mav = new ModelAndView("registration");
		mav.addObject("input1", name);
		
		return mav;
	}
	@RequestMapping("/form")
	public ModelAndView showCoffeeShopRegistration( ) {
		ModelAndView mav = new ModelAndView("CoffeeShopForm");
		
		return mav;
}
	@RequestMapping("/summary")
	public ModelAndView showsummary(@RequestParam("Name") String name ,@RequestParam("Age") String age, @RequestParam("Email") String email, @RequestParam("Phone_Number") String phonenumber) {
		ModelAndView mav = new ModelAndView("summary");
		mav.addObject("name", name);
		mav.addObject("age", age);
		mav.addObject("email", email);
		mav.addObject("phone_number", phonenumber);

		return mav;
	}
	@RequestMapping("/items")
	public ModelAndView listCoffee(@RequestParam(value="category", required=false) String category) {
		ModelAndView mav = new ModelAndView("list-items");
		if (category != null && !category.isEmpty()) {
			mav.addObject("items", CoffeeShopService.getCoffeeInCategory(category));
			mav.addObject("category", category);
		} else {
			mav.addObject("items", CoffeeShopService.getAllCoffee());
		}
		return mav;
	}
	
	@RequestMapping("/add-items")
	public ModelAndView showCofeeForm() {
		return new ModelAndView("items-form");
	}
	
	// Two controllers handling the same URL path, but this one handles the POST
	// which is triggered when the form submits.
	@RequestMapping(value="/add-items", method=RequestMethod.POST)
	// When a POJO (Java Bean) is provided as a parameter, Spring MVC automatically
	// fills in all the properties from the request params!
	public ModelAndView submitCoffeeForm(Coffee items) {
		CoffeeShopService.addCoffee(items);
		// using a view name that starts with "redirect:" skips the JSP and instead
		// redirects the browser to the given URL, effectively redirecting to another
		// controller.
		return new ModelAndView("redirect:/items");
	}
}

