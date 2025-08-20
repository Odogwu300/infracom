package com.eclipse.infracom.Repository;

import com.eclipse.infracom.model.Emplacement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmplacementRepository extends JpaRepository<Emplacement, Long> {

    // Tu peux ajouter ici des méthodes personnalisées si besoin.
    // Exemple :
    // List<Emplacement> findByType(String type);
}

