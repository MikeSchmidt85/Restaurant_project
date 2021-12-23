package com.mike.mikes_restaurant.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

//import com.mike.mikes_restaurant.models.User;

@Entity
@Table(name = "pizza")
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 0, max = 200)
	private String name;
	
	@NotNull
	@Size(min = 0, max = 200)
	private String crust;

	@NotNull
	@Size(min = 0, max = 200)
	private String sauce;
	
	@NotNull
	@Size(min = 0, max = 200)
	private String cheese;

	@NotNull
	@Size(min = 0, max = 200)
	private String meats;

	@NotNull
	@Size(min = 0, max = 200)
	private String veggies;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyy-MM-dd")
	private Date updatedAt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCrust() {
		return crust;
	}

	public void setCrust(String crust) {
		this.crust = crust;

	}
		
	public String getSauce() {
		return sauce;
	}

	public void setSauce(String sauce) {
		this.sauce = sauce;
	}


	public String getCheese() {
		return cheese;
	}

	public void setCheese(String cheese) {
		this.cheese = cheese;
	}

	public String getMeats() {
		return meats;
	}

	public void setMeats(String meats) {
		this.meats = meats;
	}

	public String getVeggies() {
		return veggies;
	}

	public void setVeggies(String veggies) {
		this.veggies = veggies;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
