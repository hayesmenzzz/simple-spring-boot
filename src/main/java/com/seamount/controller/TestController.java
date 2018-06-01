package com.seamount.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

public class TestController {

	@RequestMapping("/")
	public String index(){
		return "Hello!";
	}
}
