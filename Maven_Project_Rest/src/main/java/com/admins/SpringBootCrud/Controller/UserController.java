package com.admins.SpringBootCrud.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admins.SpringBootCrud.Payloads.ApiResponse;
import com.admins.SpringBootCrud.Payloads.Dto;
import com.admins.SpringBootCrud.Service.UserService;

@RestController
@RequestMapping("/api/users")
 	
public class UserController {
	@Autowired
	private UserService userService;
	//POST- Create user
	
	
	@PostMapping("/")
	public ResponseEntity<Dto> createUser(@RequestBody Dto dto)
	{
		Dto createUserDto =this.userService.userCreate(dto);
		return  new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
	}
	
	
	// PUT -Update user
	@PutMapping("/{userId}")
	public ResponseEntity<Dto> updateUser(@RequestBody Dto dto ,@PathVariable ("userId") Integer userId)
	{
	Dto updatedUser =this.userService.userUpdate(dto, userId);
	return ResponseEntity.ok(updatedUser);
	}

	
	//DELETE - Delete user
	@DeleteMapping("/{userId}")
	  public ResponseEntity<ApiResponse> deleteUser(@PathVariable ("userId") Integer userId)
	  {
		this.userService.deleteuser(userId);
		return new ResponseEntity(new ApiResponse("User deleted Successfully", true),HttpStatus.OK);
		
	  }
	// GET - user get
	@GetMapping("/")
	public ResponseEntity<List<Dto>> getAllUsers()
	{
		return ResponseEntity.ok(this.userService.getAlluser());
	}
	
	//  GET - single User Id
	     
	@GetMapping("/{userId}")
	public ResponseEntity<Dto> getsingleUser(@PathVariable ("userId") Integer userId)
	{
		return ResponseEntity.ok(this.userService.getuserbyId(userId));
	}

}
