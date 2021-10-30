package com.mohammad.flightreservation.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mohammad.flightreservation.entities.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

	@Query("from Flight where departureCity=:departureCity and arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture")
	public List<Flight> FindFlights(@Param("departureCity") String from,
									@Param("arrivalCity") String to,
									@Param("dateOfDeparture") Date departureDate);
	

}
