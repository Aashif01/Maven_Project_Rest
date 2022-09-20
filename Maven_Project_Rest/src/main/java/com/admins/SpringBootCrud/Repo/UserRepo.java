package com.admins.SpringBootCrud.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admins.SpringBootCrud.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	

}
