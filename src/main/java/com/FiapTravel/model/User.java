package com.FiapTravel.model;

import com.FiapTravel.model.enums.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Table(name = "users")
@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class User {

	
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  private String login;
  private String password;
  private UserRole role;
  
  public User(String login, String password, UserRole role){
	  this.login = login;
	  this.password = password;
	  this.role = role;
	  
  }

  
}

