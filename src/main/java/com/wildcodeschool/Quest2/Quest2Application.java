package com.wildcodeschool.Quest2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class Quest2Application {

	public static void main(String[] args) {
		SpringApplication.run(Quest2Application.class, args);
	}

	@GetMapping("/doctor/{number}")
	public ResponseEntity<Object> getDoctor(@PathVariable int number) {
		if (number >= 9 && number <= 13) {
			switch (number) {
				case 9:
					return new ResponseEntity<>(new Doctor(9, "Christopher Eccleston"), HttpStatus.OK);
				case 10:
					return new ResponseEntity<>(new Doctor(10, "David Tennant"), HttpStatus.OK);
				case 11:
					return new ResponseEntity<>(new Doctor(11, "Matt Smith"), HttpStatus.OK);
				case 12:
					return new ResponseEntity<>(new Doctor(12, "Peter Capaldi"), HttpStatus.OK);
				case 13:
					return new ResponseEntity<>(new Doctor(13, "Jodie Whittaker"), HttpStatus.OK);
			}
		} else if (number >= 1 && number <= 8) {
			return new ResponseEntity<>(HttpStatus.SEE_OTHER);
		}
		return new ResponseEntity<>("Impossible to retrieve the incarnation " + number, HttpStatus.NOT_FOUND);
	}
}
