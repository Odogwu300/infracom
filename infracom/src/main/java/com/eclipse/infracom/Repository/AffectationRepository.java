package com.eclipse.infracom.Repository;

import com.eclipse.infracom.model.Affectation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AffectationRepository extends JpaRepository<Affectation, Long> {
    List<Affectation> findByUsagerId(Long usagerId);
}
