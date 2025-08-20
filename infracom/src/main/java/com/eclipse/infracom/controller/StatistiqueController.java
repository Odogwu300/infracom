package com.eclipse.infracom.controller;

import com.eclipse.infracom.dto.StatistiqueDto;
import com.eclipse.infracom.service.StatistiqueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/statistiques")
@RequiredArgsConstructor
public class StatistiqueController {

    private final StatistiqueService statistiqueService;

    @GetMapping("/occupations")
    public StatistiqueDto getOccupations() {
        return statistiqueService.getOccupations();
    }

    @GetMapping("/paiements")
    public StatistiqueDto getPaiements() {
        return statistiqueService.getPaiements();
    }
}
