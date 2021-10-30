package com.mohammad.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohammad.flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
