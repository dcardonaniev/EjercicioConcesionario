package me.davidlake.proyectoconcesionario.service;

import me.davidlake.proyectoconcesionario.dto.response.VehicleDTO;
import me.davidlake.proyectoconcesionario.dto.request.CreateVehicleRequestDTO;
import me.davidlake.proyectoconcesionario.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    Vehicle createVehicle(CreateVehicleRequestDTO vehicle);
    List<VehicleDTO> getAll();
    List<VehicleDTO> getBetweenDates(String initialDate, String finalDate);
    List<VehicleDTO> getBetweenPrices(String minPrice, String maxPrice);
    Vehicle getById(Long id);
}