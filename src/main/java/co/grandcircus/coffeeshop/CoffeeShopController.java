package co.grandcircus.coffeeshop;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoffeeShopController {
	
	@RequestMapping("/")
	public ModelAndView showHomePage() {
		ModelAndView mav = new ModelAndView("index");
		
		return mav;

}
	
	
	@RequestMapping("/registration")
	public ModelAndView showCoffeeShopRegistration(@RequestParam("name") String name ) {
		ModelAndView mav = new ModelAndView("registration");
		mav.addObject("input1", name);
		
		return mav;
	}
}
