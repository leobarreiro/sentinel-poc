package org.redispoc.sentinelpoc.controller;

import org.redispoc.sentinelpoc.service.ApiBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiBaseController {

	@Autowired
	private ApiBaseService service;

	@GetMapping("/hello")
	public ResponseEntity<String> helloWorld() {
		return new ResponseEntity<>(service.hello(), HttpStatus.OK);
	}

	@GetMapping(path = "/date-now")
	public ResponseEntity<String> localDateNow() {
		return new ResponseEntity<>(service.localDate(), HttpStatus.OK);
	}

}
