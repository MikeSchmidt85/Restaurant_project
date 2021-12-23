package com.mike.mikes_restaurant.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mike.mikes_restaurant.models.LoginUser;
import com.mike.mikes_restaurant.models.Pizza;
import com.mike.mikes_restaurant.models.User;
import com.mike.mikes_restaurant.services.PizzaService;
import com.mike.mikes_restaurant.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userServ;
    @Autowired
    private PizzaService pizzaServ;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}

	@PostMapping("/")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {
		userServ.register(newUser, result);
		if (result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/homepage";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "login.jsp";
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {
		User user = userServ.login(newLogin, result);
		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "login.jsp";
		}
		session.setAttribute("user_id", user.getId());
		return "redirect:/homepage";
	}

	// dashboard
	// read
	@GetMapping("/homepage")
	public String homepage(@ModelAttribute ("pizza") Pizza pizza, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("user_id");
		if (userId == null) {
			return "redirect:/";
		} else {
			User theUser = userServ.findUser(userId);
			model.addAttribute("theUser", theUser);
			List<Pizza> allPizzas = pizzaServ.allpizzas();
			model.addAttribute("allPizzas", allPizzas);
			return "homepage.jsp";
		}
	}

//Create a pizza
	@GetMapping("/pizzas/new")
	public String createPizza(@ModelAttribute("pizza") Pizza pizza, Model model, HttpSession session) {
		List<User> allUsers = userServ.allUsers();
		model.addAttribute("allUsers", allUsers);
		Long userId = (Long) session.getAttribute("user_id");
		model.addAttribute("user_Id", userId);
		return "newpizza.jsp";

	}

	@PostMapping("/pizzas/new")
	public String create(@Valid @ModelAttribute("pizza") Pizza pizza, BindingResult result, Model model,
			HttpSession session) {
		if (result.hasErrors()) {
//		List<User> allUsers = userServ.allUsers();
//		model.addAttribute("allUsers", allUsers);

			return "newpizza.jsp";
		} else {

			pizzaServ.createPizza(pizza);
			return "redirect:/homepage";
		}
	}

//Read One
	@RequestMapping("pizzas/{id}")
	public String readOne(@PathVariable("id") Long id, Model model, HttpSession session) {
		Pizza OnePizza = pizzaServ.findPizza(id);
		model.addAttribute("pizza", OnePizza);
		List<Pizza> allPizzas = pizzaServ.allpizzas();
		model.addAttribute("allPizzas", allPizzas);
		return "pizza.jsp";

	}
	
	//Edit
    // other methods removed for brevity
    @RequestMapping("/pizzas/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
        Pizza pizza = pizzaServ.findPizza(id);
        model.addAttribute("pizza", pizza);
        Long userId = (Long) session.getAttribute("user_id");
        model.addAttribute("user_Id", userId);
        return "editpizza.jsp";
    }
    
    @RequestMapping(value="/pizzas/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("pizza") Pizza pizza, BindingResult result) {
        if (result.hasErrors()) {
            return "editpizza.jsp";
        } else {
            pizzaServ.updatePizza(pizza);
            return "redirect:/homepage";
        }
    }


//Delete
@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
public String delete(@PathVariable("id") Long id) {
    pizzaServ.deletePizza(id);
    return "redirect:/homepage";
}

}
