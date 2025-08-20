package com.eclipse.infracom.service;

import com.eclipse.infracom.dto.DocumentDto;
import com.eclipse.infracom.dto.EquipementDto;
import com.eclipse.infracom.model.Equipement;
import com.eclipse.infracom.Repository.EquipementRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EquipementServiceImpl implements EquipementService {

    private final EquipementRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<EquipementDto> findAll() {
        return repository.findAll()
                .stream()
                .map(e -> mapper.map(e, EquipementDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public EquipementDto save(EquipementDto dto) {
        Equipement e = mapper.map(dto, Equipement.class);
        return mapper.map(repository.save(e), EquipementDto.class);
    }

    @Override
    public EquipementDto update(Long id, EquipementDto dto) {
        Equipement e = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Équipement introuvable"));
        e.setType(dto.getType());
        e.setNumero(dto.getNumero());
        return mapper.map(repository.save(e), EquipementDto.class);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public EquipementDto addDocument(Long id, DocumentDto document) {
        Equipement e = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Équipement introuvable"));
        e.getDocuments().add(document.getContenu());
        return mapper.map(repository.save(e), EquipementDto.class);
    }

    @Override
    public EquipementDto removeDocument(Long id, int index) {
        Equipement e = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Équipement introuvable"));
        if (index >= 0 && index < e.getDocuments().size()) {
            e.getDocuments().remove(index);
            return mapper.map(repository.save(e), EquipementDto.class);
        } else {
            throw new RuntimeException("Index de document invalide");
        }
    }

    @Override
    public List<EquipementDto> search(String type, String etat) {
        return repository.findAll()
                .stream()
                .filter(e -> (type == null || e.getType().equalsIgnoreCase(type)))
                .filter(e -> (etat == null || e.getEtat().equalsIgnoreCase(etat)))
                .map(e -> mapper.map(e, EquipementDto.class))
                .collect(Collectors.toList());
    }
}