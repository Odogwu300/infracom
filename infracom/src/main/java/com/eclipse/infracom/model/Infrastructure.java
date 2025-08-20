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
@Table(name = "infrastructure")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Infrastructure implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String localisation;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String carteSIG;

    @OneToMany(mappedBy = "infrastructure")
    private List<Equipement> equipements;

}
