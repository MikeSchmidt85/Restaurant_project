package com.mike.mikes_restaurant.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mike.mikes_restaurant.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByEmail(String email);
	List<User> findAll();
}
