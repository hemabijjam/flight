package com.mohammad.flightreservation.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mohammad.flightreservation.controllers.ReservationController;
import com.mohammad.flightreservation.dto.ReservationRequest;
import com.mohammad.flightreservation.entities.Flight;
import com.mohammad.flightreservation.entities.Passenger;
import com.mohammad.flightreservation.entities.Reservation;
import com.mohammad.flightreservation.repos.FlightRepository;
import com.mohammad.flightreservation.repos.PassengerRepository;
import com.mohammad.flightreservation.repos.ReservationRepository;
import com.mohammad.flightreservation.util.EmailUtil;
import com.mohammad.flightreservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Value("${com.mohammad.flightreservation.itinerary.dirpath}")
	private String ITINERARY_DIR;

	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private PDFGenerator pdfGenerator;
	
	@Autowired
	private EmailUtil emailUtil;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);
	
	@Override
	@Transactional
	public Reservation bookFlight(ReservationRequest request) {
		
		LOGGER.info("Inside bookFlight() ");
		//Money Payment gateway use here 
		
		Long flightId = request.getFlightId();
		LOGGER.info("Fetching Flight for Flight Id : "+flightId);
		Flight flight = flightRepository.getOne(flightId);
		
		Passenger passenger=new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		LOGGER.info("Saving the Passenger : "+passenger);
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		LOGGER.info("Saving the Reservation : "+reservation);
		Reservation savedReservation = reservationRepository.save(reservation);
		
		String filePath = ITINERARY_DIR+savedReservation.getId()+".pdf";
		
		LOGGER.info("Generating the Itinerary ");
		pdfGenerator.generateItinerary(savedReservation, filePath);
		LOGGER.info("Emailing the Itinerary ");
		emailUtil.sendItinerary(passenger.getEmail(), filePath);
		
		return savedReservation;
	}

}
