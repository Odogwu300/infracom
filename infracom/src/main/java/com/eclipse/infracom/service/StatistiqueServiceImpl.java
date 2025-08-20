package com.eclipse.infracom.service;

import com.eclipse.infracom.dto.StatistiqueDto;
import com.eclipse.infracom.Repository.AffectationRepository;
import com.eclipse.infracom.Repository.MaintenanceRepository;
import com.eclipse.infracom.Repository.PaiementRepository;
import com.eclipse.infracom.Repository.UsagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatistiqueServiceImpl implements StatistiqueService {

    private final UsagerRepository usagerRepository;
    private final PaiementRepository paiementRepository;
    private final AffectationRepository affectationRepository;
    private final MaintenanceRepository maintenanceRepository;

    @Override
    public StatistiqueDto getOccupations() {
        return StatistiqueDto.builder()
                .totalUsagers(usagerRepository.count())
                .totalAffectations(affectationRepository.count())
                .totalMaintenances(maintenanceRepository.count())
                .totalPaiements(paiementRepository.count())
                .build();
    }

    @Override
    public StatistiqueDto getPaiements() {
        return getOccupations(); // ou statistiques plus détaillées si besoin
    }
}

