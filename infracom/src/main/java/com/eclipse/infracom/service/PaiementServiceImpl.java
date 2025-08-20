package com.eclipse.infracom.service;

import com.eclipse.infracom.dto.PaiementDto;
import com.eclipse.infracom.dto.PaiementRequest;
import com.eclipse.infracom.model.Paiement;
import com.eclipse.infracom.model.Usager;
import com.eclipse.infracom.Repository.PaiementRepository;
import com.eclipse.infracom.Repository.UsagerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaiementServiceImpl implements PaiementService {

    private final PaiementRepository repository;
    private final UsagerRepository usagerRepository;
    private final ModelMapper mapper;

    @Override
    public PaiementDto payer(PaiementRequest request) {
        Usager usager = usagerRepository.findById(request.getUsagerId())
                .orElseThrow(() -> new RuntimeException("Usager introuvable"));

        Paiement paiement = Paiement.builder()
                .montant(BigDecimal.valueOf(request.getMontant()))
                .datePaiement(LocalDate.from(LocalDateTime.now()))
                .usager(usager)
                .build();

        return mapper.map(repository.save(paiement), PaiementDto.class);
    }

    @Override
    public List<PaiementDto> getByUsager(Long usagerId) {
        return repository.findByUsagerId(usagerId)
                .stream()
                .map(p -> mapper.map(p, PaiementDto.class))
                .collect(Collectors.toList());
    }
}
