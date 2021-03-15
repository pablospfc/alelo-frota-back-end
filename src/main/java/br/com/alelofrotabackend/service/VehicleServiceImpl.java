package br.com.alelofrotabackend.service;

import br.com.alelofrotabackend.entity.Vehicle;
import br.com.alelofrotabackend.entity.dto.VehicleDTO;
import br.com.alelofrotabackend.exceptions.NoPermissionUpdateVehicle;
import br.com.alelofrotabackend.exceptions.ResourceExistsException;
import br.com.alelofrotabackend.exceptions.ResourceNotFoundException;
import br.com.alelofrotabackend.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<Vehicle> getAll(double price, Pageable pageable) {
        return null;
    }

    @Override
    public Vehicle getById(Long id) {
        return vehicleRepository.getById(id);
    }

    @Override
    public Vehicle save(Vehicle vehicle) throws ResourceExistsException {
        Vehicle ve = vehicleRepository.getById(vehicle.getId());
         if (ve != null) {
             throw new ResourceExistsException("Este veículo já existe no sistema.");
         }

        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle update(Vehicle vehicle) throws ResourceNotFoundException, NoPermissionUpdateVehicle {
        Vehicle ve = vehicleRepository.getById(vehicle.getId());

        if (ve == null) {
            throw new ResourceNotFoundException("Veículo não encontrado");
        }

        if (ve.getPlate().equals(vehicle.getPlate())) {
            throw new NoPermissionUpdateVehicle("Operação não permitoda. Não é possível modificar a placa do veículo");
        }

        return vehicleRepository.save(vehicle);
    }

    @Override
    public void deleteById(Long id) throws ResourceNotFoundException {
        Vehicle vehicle = vehicleRepository.getById(id);

        if (vehicle == null) {
            throw new ResourceNotFoundException("Veículo não encontrado");
        }

        vehicleRepository.deleteById(id);
    }

    @Override
    public Vehicle getByPlate(String plate) {
        return vehicleRepository.getByPlate(plate);
    }

}
