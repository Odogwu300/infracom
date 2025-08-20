package com.eclipse.infracom.service;

import com.eclipse.infracom.dto.MaintenanceDto;
import com.eclipse.infracom.dto.MaintenanceRequest;
import com.eclipse.infracom.model.Infrastructure;
import com.eclipse.infracom.model.Maintenance;
import com.eclipse.infracom.Repository.InfrastructureRepository;
import com.eclipse.infracom.Repository.MaintenanceRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MaintenanceServiceImpl implements MaintenanceService {

    private final MaintenanceRepository repository;
    private final InfrastructureRepository infrastructureRepository;
    private final ModelMapper mapper;

    @Override
    public MaintenanceDto planifier(MaintenanceRequest request) {
        Infrastructure infra = infrastructureRepository.findById(request.getInfrastructureId())
                .orElseThrow(() -> new RuntimeException("Infrastructure non trouvée"));

        Maintenance maintenance = Maintenance.builder()
                .description(request.getDescription())
                .dateSignalement(request.getDate())
                .infrastructure(infra)
                .build();

        return mapper.map(repository.save(maintenance), MaintenanceDto.class);
    }

    @Override
    public List<MaintenanceDto> getByInfrastructure(Long id) {
        return repository.findByInfrastructureId(id)
                .stream()
                .map(m -> mapper.map(m, MaintenanceDto.class))
                .collect(Collectors.toList());
    }
}
