package com.eclipse.infracom.service;

import com.eclipse.infracom.dto.AffectationDto;
import com.eclipse.infracom.dto.AffectationRequest;
import com.eclipse.infracom.model.Affectation;
import com.eclipse.infracom.model.Emplacement;
import com.eclipse.infracom.model.Usager;
import com.eclipse.infracom.Repository.AffectationRepository;
import com.eclipse.infracom.Repository.EmplacementRepository;
import com.eclipse.infracom.Repository.UsagerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AffectationServiceImpl implements AffectationService {

    private final AffectationRepository repository;
    private final UsagerRepository usagerRepository;
    private final EmplacementRepository emplacementRepository;
    private final ModelMapper mapper;

    @Override
    public AffectationDto affecter(AffectationRequest request) {
        Usager usager = usagerRepository.findById(request.getUsagerId())
                .orElseThrow(() -> new RuntimeException("Usager non trouvé"));
        Emplacement emplacement = emplacementRepository.findById(request.getEmplacementId())
                .orElseThrow(() -> new RuntimeException("Emplacement non trouvé"));

        Affectation affectation = Affectation.builder()
                .usager(usager)
                .emplacement(emplacement)
                .dateDebut(request.getDateDebut())
                .dateFin(request.getDateFin())
                .build();

        return mapper.map(repository.save(affectation), AffectationDto.class);
    }

    @Override
    public List<AffectationDto> getByUsager(Long usagerId) {
        return repository.findByUsagerId(usagerId)
                .stream()
                .map(a -> mapper.map(a, AffectationDto.class))
                .collect(Collectors.toList());
    }
}
