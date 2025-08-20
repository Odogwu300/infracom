package com.eclipse.infracom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "equipement")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Equipement implements Serializable {

    @Serial
    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String numero;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String dimension;
    @Column(nullable = false)
    private String etat;
    @Column(nullable = false)
    private String localisation;
    @Column(nullable = false)
    private BigDecimal valeurLocative;

    @ElementCollection
    private List<String> documents;

    @ManyToOne
    private Infrastructure infrastructure;

    @OneToMany(mappedBy = "equipement")
    private List<Maintenance> maintenances;
}
