package com.eclipse.infracom.Repository;

import com.eclipse.infracom.model.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {
    List<Maintenance> findByInfrastructureId(Long infrastructureId);
}
