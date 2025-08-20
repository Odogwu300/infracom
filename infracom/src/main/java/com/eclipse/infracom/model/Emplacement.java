package com.eclipse.infracom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "emplacement")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Emplacement implements Serializable {

        @Serial
        private static final long serialVersionUID = 45623121L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(nullable = false)
        private String code;
        @Column(nullable = false)
        private String statut;

        @OneToOne(mappedBy = "emplacement")
        private Affectation affectation;

}
