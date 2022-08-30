package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.dto.FlightDTO;
import com.capg.dto.SearchRequest;
import com.capg.dto.SearchResponce;
import com.capg.service.FlightService;


@RestController
@RequestMapping("/flights")
public class FlightSearchController {

	@Autowired
	private FlightService service;
	
	
	@PostMapping( "/details")
	public SearchResponce getFlightDetails(@RequestBody SearchRequest request) {
		List<FlightDTO> details=service.getFlightDetails(request);
		SearchResponce responce=new SearchResponce();
		responce.setFlightdetails(details);
		return responce;
	}
	
	@GetMapping("/{name}")
	public SearchResponce getFlightDetailsByName(@PathVariable("name")String name) {
		List<FlightDTO> details=service.getFlightByName(name);
		SearchResponce responce=new SearchResponce();
		responce.setFlightdetails(details);
		return responce;
		
	}
	
	
	@GetMapping( "/hello")
	public String getFlightDetails() {
		return "WELCOME TO FLIGHT BOOKING SYSTEM";
	}
	
	
}
