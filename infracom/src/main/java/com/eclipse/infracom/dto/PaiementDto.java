package com.eclipse.infracom.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaiementDto {
    private Long id;
    private Double montant;
    private LocalDateTime datePaiement;
    private Long usagerId;
}
