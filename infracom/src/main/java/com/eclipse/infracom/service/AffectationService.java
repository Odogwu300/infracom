package com.eclipse.infracom.service;

import com.eclipse.infracom.dto.AffectationDto;
import com.eclipse.infracom.dto.AffectationRequest;

import java.util.List;

public interface AffectationService {
    AffectationDto affecter(AffectationRequest request);
    List<AffectationDto> getByUsager(Long usagerId);
}

