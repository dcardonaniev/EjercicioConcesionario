package me.davidlake.proyectoconcesionario.repository;

import me.davidlake.proyectoconcesionario.dto.response.VehicleDTO;
import me.davidlake.proyectoconcesionario.entity.Vehicle;

import java.time.LocalDate;
import java.util.List;

public interface IVehicleRepository {
    Vehicle createVehicle(Vehicle vehicle);
    List<Vehicle> getAll();
    List<Vehicle> getBetweenDates(LocalDate initialDate, LocalDate finalDate);
    List<Vehicle> getBetweenPrices(String minPrice, String maxPrice);
    Vehicle getById(Long id);
}