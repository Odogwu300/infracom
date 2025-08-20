package com.eclipse.infracom.controller;

import com.eclipse.infracom.dto.DocumentDto;
import com.eclipse.infracom.dto.EquipementDto;
import com.eclipse.infracom.service.EquipementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipements")
@RequiredArgsConstructor
public class EquipementController {

    private final EquipementService equipementService;

    @GetMapping
    public List<EquipementDto> getAll() {
        return equipementService.findAll();
    }

    @PostMapping
    public EquipementDto create(@RequestBody EquipementDto dto) {
        return equipementService.save(dto);
    }

    @PutMapping("/{id}")
    public EquipementDto update(@PathVariable Long id, @RequestBody EquipementDto dto) {
        return equipementService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        equipementService.delete(id);
    }

    @PostMapping("/{id}/documents")
    public EquipementDto addDocument(@PathVariable Long id, @RequestBody DocumentDto document) {
        return equipementService.addDocument(id, document);
    }

    @DeleteMapping("/{id}/documents/{index}")
    public EquipementDto removeDocument(@PathVariable Long id, @PathVariable int index) {
        return equipementService.removeDocument(id, index);
    }

    @GetMapping("/search")
    public List<EquipementDto> search(@RequestParam(required = false) String type,
                                      @RequestParam(required = false) String etat) {
        return equipementService.search(type, etat);
    }
}