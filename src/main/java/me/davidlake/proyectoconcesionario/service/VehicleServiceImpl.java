package me.davidlake.proyectoconcesionario.service;

import me.davidlake.proyectoconcesionario.dto.request.CreateVehicleRequestDTO;
import me.davidlake.proyectoconcesionario.dto.response.VehicleDTO;
import me.davidlake.proyectoconcesionario.entity.Vehicle;
import me.davidlake.proyectoconcesionario.repository.IVehicleRepository;
import me.davidlake.proyectoconcesionario.repository.VehicleRepositoryImpl;
import me.davidlake.proyectoconcesionario.utils.MapperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

@Service
public class VehicleServiceImpl implements IVehicleService {
    private final IVehicleRepository vehicleRepository;
    private final ModelMapper modelMapper;

    public VehicleServiceImpl(
            VehicleRepositoryImpl vehicleRepository,
            ModelMapper modelMapper
    ) {
        this.vehicleRepository = vehicleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Vehicle createVehicle(@RequestBody CreateVehicleRequestDTO vehicle) {
        return vehicleRepository.createVehicle(modelMapper.map(vehicle, Vehicle.class));
    }

    @Override
    public List<VehicleDTO> getAll() {
        return vehicleRepository.getAll()
                .stream()
                .map(vehicle -> modelMapper.map(vehicle, VehicleDTO.class))
                .toList();
    }

    @Override
    public List<VehicleDTO> getBetweenDates(String initialDate, String finalDate) {
        LocalDate initialD = LocalDate.parse(initialDate);
        LocalDate finalD = LocalDate.parse(finalDate);

        System.out.printf("%s, %s", initialD, finalD);

        return vehicleRepository.getBetweenDates(initialD, finalD)
                .stream()
                .map(vehicle -> modelMapper.map(vehicle, VehicleDTO.class))
                .toList();
    }

    @Override
    public List<VehicleDTO> getBetweenPrices(String minPrice, String maxPrice) {
        return vehicleRepository.getBetweenPrices(minPrice, maxPrice)
                .stream()
                .map(vehicle -> modelMapper.map(vehicle, VehicleDTO.class))
                .toList();
    }

    @Override
    public Vehicle getById(Long id) {
        return vehicleRepository.getById(id);
    }
}
