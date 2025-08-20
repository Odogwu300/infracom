package com.eclipse.infracom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "usager")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usager implements Serializable {

    @Serial
    private static final long serialVersionUID = 13564421L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    @Column(nullable = false)
    private String telephone;
    @Column(nullable = false)
    private String adresse;
    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "usager")
    private List<Affectation> affectations;

    @OneToMany(mappedBy = "usager")
    private List<Paiement> paiements;

    @OneToMany(mappedBy = "usager")
    private List<Notification> notifications;

}
