package com.eclipse.infracom.Repository;

import com.eclipse.infracom.model.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {
    List<Paiement> findByUsagerId(Long usagerId);
}

