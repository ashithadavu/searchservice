package com.capg.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.capg.entity.FlightInfo;
//mongorepo is a built in class
public interface FlightRepository extends MongoRepository<FlightInfo,String>{
	@Query("{date:'?0'}")
	List<FlightInfo> findFlightByDate(String date);
	
	@Query("{source:'?0',destination:'?1'}")
	List<FlightInfo> findFlightBySourceDestination(String source, String destination);
	
	@Query("{name:'?0'}")
	List<FlightInfo> findFlightByName(String name);
	@Query("{:'?0'}")
	List<FlightInfo> findAll();
	@Query("{date:'?0',source:'?1',destination:'?2'}")
	List<FlightInfo> findFlight(String date,String source,String destination);

}
