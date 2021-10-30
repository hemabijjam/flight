package com.mohammad.flightreservation.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mohammad.flightreservation.dto.ReservationRequest;
import com.mohammad.flightreservation.entities.Flight;
import com.mohammad.flightreservation.entities.Reservation;
import com.mohammad.flightreservation.repos.FlightRepository;
import com.mohammad.flightreservation.services.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private ReservationService reservationService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		
		LOGGER.info("showCompleteReservation() invoked with the flight id : " + flightId);
		Optional<Flight> flight = flightRepository.findById(flightId);
		modelMap.addAttribute("flight", flight);
		LOGGER.info("Flight is : " + flight);
		return "completeReservation";
	}
	
	@RequestMapping(value="/completeReservation",method=RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		LOGGER.info("Inside completeReservation() :"+request);
		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("message", "Reservation created successfully and the id is "+ reservation.getId());
		return "reservationConfirmation";
	}

}
