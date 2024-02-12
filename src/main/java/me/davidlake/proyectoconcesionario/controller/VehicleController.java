package me.davidlake.proyectoconcesionario.controller;

import me.davidlake.proyectoconcesionario.dto.request.CreateVehicleRequestDTO;
import me.davidlake.proyectoconcesionario.dto.response.VehicleDTO;
import me.davidlake.proyectoconcesionario.entity.Vehicle;
import me.davidlake.proyectoconcesionario.service.IVehicleService;
import me.davidlake.proyectoconcesionario.service.VehicleServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehicleController {
    private final IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getAll() {
        return ResponseEntity.ok(vehicleService.getAll());
    }

    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody CreateVehicleRequestDTO createVehicleRequest) {
        return ResponseEntity.ok(vehicleService.createVehicle(createVehicleRequest));
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleDTO>> getByBetweenDates(
            @RequestParam String since,
            @RequestParam String to
    ){
        return ResponseEntity.ok(vehicleService.getBetweenDates(since, to));
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleDTO>> getByBetweenPrices(
            @RequestParam String since,
            @RequestParam String to)
    {
        return ResponseEntity.ok(vehicleService.getBetweenPrices(since, to));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleInformationById(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(vehicleService.getById(id));
    }
}
