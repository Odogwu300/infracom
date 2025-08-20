package com.eclipse.infracom.service;

import com.eclipse.infracom.dto.InfrastructureDto;

import java.util.List;

public interface InfrastructureService {
    List<InfrastructureDto> findAll();
    InfrastructureDto save(InfrastructureDto dto);
    InfrastructureDto update(Long id, InfrastructureDto dto);
    void delete(Long id);
}
