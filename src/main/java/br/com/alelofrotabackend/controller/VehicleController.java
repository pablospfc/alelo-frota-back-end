package br.com.alelofrotabackend.controller;

import br.com.alelofrotabackend.entity.Vehicle;
import br.com.alelofrotabackend.entity.dto.VehicleDTO;
import br.com.alelofrotabackend.exceptions.NoPermissionUpdateVehicle;
import br.com.alelofrotabackend.exceptions.ResourceExistsException;
import br.com.alelofrotabackend.exceptions.ResourceNotFoundException;
import br.com.alelofrotabackend.service.VehicleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@RestController
@RequestMapping(value = "/api/vehicle")
@Api(value = "Vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    public void getAll() {

    }

    @ApiOperation("Salva um veículo")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Retorna o produto cadastrado"),
            @ApiResponse(code = 400, message = "Veículo com placa já cadastrada"),
            @ApiResponse(code = 500, message = "Ocorreu alguam exceção na aplicação")
    })
    @PostMapping
    public ResponseEntity<Vehicle> save(@RequestBody VehicleDTO vehicleDTO) throws ResourceExistsException {
        return new ResponseEntity<Vehicle>(
                vehicleService.save(vehicleDTO.convertToEntity()),
                HttpStatus.CREATED
        );
    }

    @ApiOperation("Atualiza dados de um veículo")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Dados do veículo atualizado com sucesso"),
            @ApiResponse(code = 404, message = "Veículo não encontrado"),
            @ApiResponse(code = 409, message = "Atualização inválida"),
            @ApiResponse(code = 500, message = "Ocorreu alguam exceção na aplicação")
    })
    @PutMapping(value = "/{id}")
    public ResponseEntity<Vehicle> update(@PathVariable("id") Long id, @RequestBody VehicleDTO vehicleDTO) throws ResourceNotFoundException, NoPermissionUpdateVehicle {
        return new ResponseEntity<Vehicle>(
                vehicleService.update(vehicleDTO.convertToEntity()),
                HttpStatus.OK
        );
    }

    @ApiOperation("Retorna dados do veículo")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o veículo pesquisado."),
            @ApiResponse(code = 404, message = "Veículo não encontrado"),
            @ApiResponse(code = 500, message = "Ocorreu alguam exceção na aplicação")
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<Vehicle> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(
                vehicleService.getById(id),
                HttpStatus.OK
        );
    }
}
