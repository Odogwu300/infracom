package com.eclipse.infracom.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InfrastructureDto {
    private Long id;
    private String nom;
    private String localisation;
    private String type;
}
