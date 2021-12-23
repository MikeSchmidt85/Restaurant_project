package com.mike.mikes_restaurant.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mike.mikes_restaurant.models.Pizza;

public interface PizzaRepository extends CrudRepository<Pizza, Long>{
	List<Pizza> findAll();

}
