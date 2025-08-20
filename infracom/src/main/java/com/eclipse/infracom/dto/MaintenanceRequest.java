package com.eclipse.infracom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceRequest {
    private String description;
    private LocalDate date;
    private Long infrastructureId;
}

