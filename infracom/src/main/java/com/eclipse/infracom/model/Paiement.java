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
@Table(name = "paiement")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Paiement implements Serializable {

    @Serial
    private static final long serialVersionUID = 76458912331L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private BigDecimal montant;
    @Column(nullable = false)
    private LocalDate datePaiement;
    @Column(nullable = false)
    private String modePaiement;
    @Column(nullable = false)
    private String statut;
    @Column(nullable = false)
    private String avisPDF;
    @Column(nullable = false)
    private String recuPDF;

    @ManyToOne
    private Usager usager;
}
