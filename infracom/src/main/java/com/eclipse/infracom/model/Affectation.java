package com.eclipse.infracom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "affectation")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Affectation implements Serializable {

    @Serial
    private static final long serialVersionUID = 25548951L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate dateDebut;
    @Column(nullable = false)
    private LocalDate dateFin;
    @Column(nullable = false)
    private String contratPDF;

    @ManyToOne
    private Usager usager;

    @OneToOne
    private Emplacement emplacement;
}
