package com.yessenali.fleetapp.repositories;

import com.yessenali.fleetapp.models.Client;
import com.yessenali.fleetapp.models.VehicleMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleMovementRepository extends JpaRepository<VehicleMovement, Integer> {
}
