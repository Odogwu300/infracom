package com.eclipse.infracom.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsagerDto {
    private Long id;
    private String nom;
    private String prenom;
    private String telephone;
    private String adresse;
    private String email;
}
