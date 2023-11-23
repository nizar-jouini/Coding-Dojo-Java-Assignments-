package com.nizar.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HomeController {
	@RequestMapping("")
	public String index() {
		return "Hello World";
	}
	
	@RequestMapping("/new")
	public String newRoute() {
		return "it is the new route";
	}
	
	// you can be explicit about the request as well
    @RequestMapping(value="/greeting", method=RequestMethod.GET)
    public String hello(){
      return "Hello world! What route did you use to access me?";
    }

}
