package com.admins.SpringBootCrud.ServiceImpl;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admins.SpringBootCrud.Exception.*;
import com.admins.SpringBootCrud.Entity.User;
import com.admins.SpringBootCrud.Payloads.Dto;
import com.admins.SpringBootCrud.Repo.UserRepo;
import com.admins.SpringBootCrud.Service.UserService;

@Service

public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;

	@Override
	public Dto userCreate(Dto userDto) {

		User user = this.DtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToDDto(savedUser);
	}
	
	  
	  @Override public Dto userUpdate(Dto user, Integer userId) {
	  
	  User User=this.userRepo.findById(userId).orElseThrow(()->new
	  ResourseNotFoundException("User","Id",userId));
	  
	  user.setName(user.getName());
	  user.setEmail(user.getEmail());
	  user.setPassword(user.getPassword());
	  user.setInfo(user.getInfo());
	  
	  
	  User updateUser = this.userRepo.save(User);
	  Dto Dto1=this.userToDDto(updateUser);
	  
	  return Dto1;
	  
	  }
	 

	@Override
	public Dto getuserbyId(Integer userId) {

		User User = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourseNotFoundException("User", "Id", userId));

		return this.userToDDto(User);
	}

	@Override
	public List<Dto> getAlluser() {

		List<User> users = this.userRepo.findAll();
		List<Dto> Dtos = users.stream().map(user -> this.userToDDto(user)).collect(Collectors.toList());
		return Dtos;
	}

	@Override
	public void deleteuser(Integer userId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourseNotFoundException("User", "Id", userId));
		this.userRepo.delete(user);

	}

	public User DtoToUser(Dto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setGmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setInfo(userDto.getInfo());
		return user;

	}

	public Dto userToDDto(User user) {
		Dto userDto = new Dto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getGmail());
		userDto.setPassword(user.getPassword());
		userDto.setInfo(user.getInfo());
		return userDto;
	}

}
