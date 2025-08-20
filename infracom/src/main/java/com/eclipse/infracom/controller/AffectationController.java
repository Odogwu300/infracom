package com.eclipse.infracom.controller;

import com.eclipse.infracom.dto.AffectationDto;
import com.eclipse.infracom.dto.AffectationRequest;
import com.eclipse.infracom.service.AffectationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/affectations")
@RequiredArgsConstructor
public class AffectationController {

    private final AffectationService affectationService;

    @PostMapping
    public AffectationDto affecter(@RequestBody AffectationRequest request) {
        return affectationService.affecter(request);
    }

    @GetMapping("/usager/{id}")
    public List<AffectationDto> getByUsager(@PathVariable Long id) {
        return affectationService.getByUsager(id);
    }
}
