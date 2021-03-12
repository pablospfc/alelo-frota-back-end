package br.com.alelofrotabackend.entity.dto;

import br.com.alelofrotabackend.entity.Vehicle;
import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO  {

    private Long id;

    @NotNull
    private String plate;

    @NotNull
    private String model;

    @NotNull
    private String manufacturer;

    @NotNull
    private String color;

    private Boolean status;

    public Vehicle convertToEntity() {
        return new ModelMapper().map(this, Vehicle.class);
    }
}
