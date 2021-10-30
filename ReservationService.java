package com.mohammad.flightreservation.services;

import com.mohammad.flightreservation.dto.ReservationRequest;
import com.mohammad.flightreservation.entities.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);

}
