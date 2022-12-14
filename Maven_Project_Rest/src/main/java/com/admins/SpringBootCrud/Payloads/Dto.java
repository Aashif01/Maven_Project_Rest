package com.admins.SpringBootCrud.Payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Dto {
	private int id;
	private String name;
	private String email;
	private String password;
	private String info;

}

