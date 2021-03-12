package br.com.alelofrotabackend.repository;

import br.com.alelofrotabackend.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Vehicle getById(Long id);
    Vehicle getByPlate(String plate);
}
