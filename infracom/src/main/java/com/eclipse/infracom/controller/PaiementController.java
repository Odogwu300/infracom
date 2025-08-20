package com.eclipse.infracom.controller;

import com.eclipse.infracom.dto.PaiementDto;
import com.eclipse.infracom.dto.PaiementRequest;
import com.eclipse.infracom.service.PaiementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
@RequiredArgsConstructor
public class PaiementController {

    private final PaiementService paiementService;

    @PostMapping
    public PaiementDto effectuerPaiement(@RequestBody PaiementRequest request) {
        return paiementService.payer(request);
    }

    @GetMapping("/usager/{id}")
    public List<PaiementDto> getByUsager(@PathVariable Long id) {
        return paiementService.getByUsager(id);
    }
}
