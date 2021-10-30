package com.mohammad.flightreservation.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohammad.flightreservation.dto.ReservationUpdateRequest;
import com.mohammad.flightreservation.entities.Reservation;
import com.mohammad.flightreservation.repos.ReservationRepository;

@RestController
public class ReservationRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);
	
	private ReservationRepository reservationRepository;
	
	@RequestMapping("/reservations/{id}")
	public Optional<Reservation> findReservation(@PathVariable Long id) {
		LOGGER.info("Inside findReservation() for id : "+id);
		return reservationRepository.findById(id);
	}
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		LOGGER.info("Inside updateReservation() for "+request);
		Reservation reservation = reservationRepository.getOne(request.getId());
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		LOGGER.info("Saving Reservation ");
		return reservationRepository.save(reservation);
		 
	}
}
