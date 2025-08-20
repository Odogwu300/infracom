package com.eclipse.infracom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AffectationRequest {
    private Long usagerId;
    private Long emplacementId;
    private LocalDate dateDebut;
    private LocalDate dateFin;
}
