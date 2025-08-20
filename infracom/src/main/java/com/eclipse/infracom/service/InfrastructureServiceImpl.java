package com.eclipse.infracom.service;

import com.eclipse.infracom.dto.InfrastructureDto;
import com.eclipse.infracom.model.Infrastructure;
import com.eclipse.infracom.Repository.InfrastructureRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InfrastructureServiceImpl implements InfrastructureService {

    private final InfrastructureRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<InfrastructureDto> findAll() {
        return repository.findAll()
                .stream()
                .map(infra -> mapper.map(infra, InfrastructureDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public InfrastructureDto save(InfrastructureDto dto) {
        Infrastructure infra = mapper.map(dto, Infrastructure.class);
        return mapper.map(repository.save(infra), InfrastructureDto.class);
    }

    @Override
    public InfrastructureDto update(Long id, InfrastructureDto dto) {
        Infrastructure existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Infrastructure introuvable"));
        existing.setNom(dto.getNom());
        existing.setLocalisation(dto.getLocalisation());
        existing.setType(dto.getType());
        return mapper.map(repository.save(existing), InfrastructureDto.class);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
