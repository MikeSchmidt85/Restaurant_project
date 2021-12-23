package com.mike.mikes_restaurant.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mike.mikes_restaurant.models.Pizza;
import com.mike.mikes_restaurant.repos.PizzaRepository;

@Service
public class PizzaService {

	
	@Autowired
	private final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }
    
    
    // returns all the pizzas
    public List<Pizza> allpizzas() {
        return pizzaRepository.findAll();
    }
    // creates a pizza
    public Pizza createPizza(Pizza p) {
        return pizzaRepository.save(p);
    }
    
    
    // returns a pizza
    public Pizza findPizza(Long id) {
        Optional<Pizza> optionalPizza = pizzaRepository.findById(id);
        if(optionalPizza.isPresent()) {
            return optionalPizza.get();
        } else {
            return null;
        }
    }
    //edits a pizza
    public Pizza updatePizza(Pizza p) {
		return pizzaRepository.save(p);
    }
    
    
    
	//Delete a pizza
    public void deletePizza(Long id) {
    	pizzaRepository.deleteById(id);
    }

}
