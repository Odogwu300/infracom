package com.eclipse.infracom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "maintenance")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Maintenance implements Serializable {

    @Serial
    private static final long serialVersionUID = 231457891L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private LocalDate dateSignalement;
    @Column(nullable = false)
    private LocalDate dateIntervention;
    @Column(nullable = false)
    private String statut;
    @Column(nullable = false)
    private BigDecimal budgetEstime;

    @ManyToOne
    private Equipement equipement;

    @ManyToOne
    private Emplacement emplacement;

    @ManyToOne
    @JoinColumn(name = "infrastructure_id", nullable = false)
    private Infrastructure infrastructure;
}
