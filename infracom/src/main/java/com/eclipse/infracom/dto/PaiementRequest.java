package com.eclipse.infracom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaiementRequest {
    private Long usagerId;
    private Double montant;
}
