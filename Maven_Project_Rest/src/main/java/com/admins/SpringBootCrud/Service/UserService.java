package com.admins.SpringBootCrud.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.admins.SpringBootCrud.Payloads.Dto;
@Service
public interface UserService {

	Dto userCreate(Dto user);// Creating the user Id
//	Dto userUpdate(Dto user,Integer userId);//Updating the user id 
	Dto getuserbyId(Integer userId);//getting user details by user Id
	List< Dto> getAlluser();// Getteing the all user Id 
	void deleteuser(Integer userId);// deleting the user Id
	Dto userUpdate(Dto user, Integer userId);
	

}
