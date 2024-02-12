package me.davidlake.proyectoconcesionario.dto.request;

import lombok.*;
import me.davidlake.proyectoconcesionario.entity.VService;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString
public class CreateVehicleRequestDTO {
    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private List<VService> services;
    private String countOfOwners;
}