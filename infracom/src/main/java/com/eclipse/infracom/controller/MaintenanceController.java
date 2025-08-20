package com.eclipse.infracom.controller;

import com.eclipse.infracom.dto.MaintenanceDto;
import com.eclipse.infracom.dto.MaintenanceRequest;
import com.eclipse.infracom.service.MaintenanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenances")
@RequiredArgsConstructor
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    @PostMapping
    public MaintenanceDto planifier(@RequestBody MaintenanceRequest request) {
        return maintenanceService.planifier(request);
    }

    @GetMapping("/infrastructure/{id}")
    public List<MaintenanceDto> getByInfrastructure(@PathVariable Long id) {
        return maintenanceService.getByInfrastructure(id);
    }
}

