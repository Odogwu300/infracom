package com.eclipse.infracom.Repository;

import com.eclipse.infracom.model.Usager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsagerRepository extends JpaRepository<Usager, Long> {
}

