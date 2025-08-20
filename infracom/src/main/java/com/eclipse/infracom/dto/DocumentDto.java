package com.eclipse.infracom.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocumentDto {
    private String contenu; // Contenu du document
    private String nom;    // Nom ou autre métadonnée (optionnel)
}