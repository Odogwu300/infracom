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
@Table(name = "tarif")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tarif implements Serializable {

    @Serial
    private static final long serialVersionUID = 564412L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String typeEquipement;
    @Column(nullable = false)
    private BigDecimal montantMensuel;
}
