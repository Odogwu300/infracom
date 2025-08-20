package com.eclipse.infracom.service;

import com.eclipse.infracom.dto.MaintenanceDto;
import com.eclipse.infracom.dto.MaintenanceRequest;

import java.util.List;

public interface MaintenanceService {
    MaintenanceDto planifier(MaintenanceRequest request);
    List<MaintenanceDto> getByInfrastructure(Long infrastructureId);
}
