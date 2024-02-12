package me.davidlake.proyectoconcesionario.repository;

import me.davidlake.proyectoconcesionario.dto.response.VehicleDTO;
import me.davidlake.proyectoconcesionario.entity.Vehicle;
import me.davidlake.proyectoconcesionario.utils.MapperUtils;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository {
    private List<Vehicle> vehicles;
    private Long index = 0L;


    public VehicleRepositoryImpl(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public Vehicle createVehicle(Vehicle newVehicle) {
        newVehicle.setId(index += 1);
        vehicles.add(newVehicle);

        return newVehicle;
    }

    @Override
    public List<Vehicle> getAll() {
        return this.vehicles;
    }

    @Override
    public List<Vehicle> getBetweenDates(LocalDate initialDate, LocalDate finalDate) {
        return this.vehicles
                .stream()
                .filter(vehicle -> {
                    boolean isAfterSince = LocalDate.parse(vehicle.getManufacturingDate()).isAfter(initialDate);
                    boolean isBeforeTo = LocalDate.parse(vehicle.getManufacturingDate()).isBefore(finalDate);

                    return isAfterSince && isBeforeTo;
                }).toList();
    }

    @Override
    public List<Vehicle> getBetweenPrices(String minPriceInput, String maxPriceInput) {
        double minPrice = Double.parseDouble(minPriceInput);
        double maxPrice = Double.parseDouble(maxPriceInput);

        return this.vehicles
                .stream()
                .filter(vehicle -> {
                    boolean checkMinPrice = Double.parseDouble(vehicle.getPrice()) >= minPrice;
                    boolean checkMaxPrice = Double.parseDouble(vehicle.getPrice()) <= maxPrice;

                    return checkMinPrice && checkMaxPrice;
                }).toList();
    }

    @Override
    public Vehicle getById(Long id) {
        return this.vehicles
                .stream()
                .filter(vehicle -> Objects.equals(vehicle.getId(), id))
                .findFirst()
                .orElse(null);
    }
}
