package com.eclipse.infracom.service;

import com.eclipse.infracom.dto.PaiementDto;
import com.eclipse.infracom.dto.PaiementRequest;

import java.util.List;

public interface PaiementService {
    PaiementDto payer(PaiementRequest request);
    List<PaiementDto> getByUsager(Long usagerId);
}
