package br.com.alelofrotabackend.entity;

import org.modelmapper.ModelMapper;
import br.com.alelofrotabackend.entity.dto.VehicleDTO;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String plate;
    @NotNull
    private String model;
    @NotNull
    private String manufacturer;
    @NotNull
    private String color;
    @NotNull
    private boolean status;


    public VehicleDTO convertToDTO() {
         return new ModelMapper().map(this, VehicleDTO.class);
    }

}
