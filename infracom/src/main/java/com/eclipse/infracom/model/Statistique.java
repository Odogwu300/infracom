package com.eclipse.infracom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "statistique")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Statistique implements Serializable {

    @Serial
    private static final long serialVersionUID = 56149232L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Float tauxOccupation;
    @Column(nullable = false)
    private BigDecimal recettesMensuelles;
    @Column(nullable = false)
    private Integer nombreEquipementsDefectueux;
}
