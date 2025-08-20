package com.eclipse.infracom.service;

import com.eclipse.infracom.dto.DocumentDto;
import com.eclipse.infracom.dto.EquipementDto;

import java.util.List;

public interface EquipementService {
    List<EquipementDto> findAll();
    EquipementDto save(EquipementDto dto);
    EquipementDto update(Long id, EquipementDto dto);
    void delete(Long id);
    EquipementDto addDocument(Long id, DocumentDto document);
    EquipementDto removeDocument(Long id, int index);
    List<EquipementDto> search(String type, String etat);
}