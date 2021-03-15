package br.com.alelofrotabackend.service;

import br.com.alelofrotabackend.entity.Vehicle;
import br.com.alelofrotabackend.exceptions.NoPermissionUpdateVehicle;
import br.com.alelofrotabackend.exceptions.ResourceExistsException;
import br.com.alelofrotabackend.exceptions.ResourceNotFoundException;

import java.awt.print.Pageable;
import java.util.List;

public interface VehicleService {

    List<Vehicle> getAll(double price, Pageable pageable);
    Vehicle getById(Long id);
    Vehicle save(Vehicle vehicle) throws ResourceExistsException;
    Vehicle update(Vehicle vehicle) throws ResourceNotFoundException, NoPermissionUpdateVehicle;
    void deleteById(Long id) throws ResourceNotFoundException;
    Vehicle getByPlate(String plate);
}
