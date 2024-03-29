package com.songw.sbp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.songw.sbp.domain.User;
import com.songw.sbp.mapper.UserMapper;

@RestController
public class HelloController {
	
	@Autowired
	private UserMapper mapper;

	@RequestMapping("/hello")
	public String hello() {
		Calculator cal = n -> n + 1;
		System.out.println(cal.calc(2));
		return "Hello 스프링부트!!...";
	}
	
	@RequestMapping(value="/helloUser/{userID}", method = RequestMethod.GET)
	public ResponseEntity<User> helloJson(@PathVariable String userID) {
		
		try {
			User user = mapper.getLoginInfo(userID);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
}

interface Calculator {
	  int calc(int n);
}