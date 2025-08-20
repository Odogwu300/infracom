package com.eclipse.infracom.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipementDto {
    private Long id;
    private String type;
    private String numero;
    private Long infrastructureId;
}
