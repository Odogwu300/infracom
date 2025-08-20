package com.eclipse.infracom.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "notification")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification implements Serializable {

    @Serial
    private static final long serialVersionUID = 872934287392L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private LocalDateTime dateEnvoi;

    private boolean lue = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usager_id", nullable = false)
    private Usager usager;
}
