package com.nizar.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/")
	public String index(@RequestParam(value = "firstName", required = false) String firstName,
						@RequestParam(value = "lastName", required = false) String lastName,
						@RequestParam(value = "times", required = false) String times) {
		
		if (firstName == null && lastName == null) {
			
			String str = "Hello Human";
			return str.repeat(Integer.valueOf(times));
			
		} else if (firstName != null && lastName == null) {
			
			String str = "Hello " + firstName;
			return str.repeat(Integer.valueOf(times));
			
		} else if (firstName != null && lastName != null) {
			
			String str = "Hello " + firstName + " " + lastName;
			return str.repeat(Integer.valueOf(times));
			
		} else {
			
			String str = "Hello " + lastName;
			return str.repeat(Integer.valueOf(times));
		}
		
	}

}
