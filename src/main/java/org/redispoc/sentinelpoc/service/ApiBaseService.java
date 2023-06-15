package org.redispoc.sentinelpoc.service;

import java.time.LocalDate;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ApiBaseService {

	@Cacheable("fecha-ahora")
	public String localDate() {
		return LocalDate.now().toString();
	}

	@Cacheable("hola")
	public String hello() {
		return "Hello";
	}

}