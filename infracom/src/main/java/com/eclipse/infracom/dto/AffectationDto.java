package com.eclipse.infracom.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AffectationDto {
    private Long id;
    private Long usagerId;
    private Long emplacementId;
    private LocalDate dateDebut;
    private LocalDate dateFin;
}
