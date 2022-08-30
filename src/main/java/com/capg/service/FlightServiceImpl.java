package com.capg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dto.FlightDTO;
import com.capg.dto.SearchRequest;
import com.capg.entity.FlightInfo;
import com.capg.repository.FlightRepository;
import com.capg.transformer.FlightTransformer;

@Service("flightService")
public class FlightServiceImpl implements FlightService{
	
	@Autowired // injecting the depenndency
	private FlightRepository flightRepository;//private fields because outside the methods
	
	@Autowired
	private FlightTransformer transformer;
	
	@Override
	public List<FlightDTO> getFlightDetails(SearchRequest request) {
		// TODO Auto-generated method stub
		List<FlightInfo> flightDetails=flightRepository.findFlight(request.getDate(),request.getSource(),request.getDestination());
		List<FlightDTO> flightDto=transformer.transform(flightDetails);
		return flightDto;
	}
	
	@Override
	public List<FlightDTO> getFlightByName(String name) {
		// TODO Auto-generated method stub
		List<FlightInfo> flightDetails=flightRepository.findFlightByName(name);
		List<FlightDTO> flightDto=transformer.transform(flightDetails);
		return flightDto;
	}

}
