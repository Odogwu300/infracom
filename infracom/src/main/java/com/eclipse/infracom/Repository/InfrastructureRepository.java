package com.eclipse.infracom.Repository;
import com.eclipse.infracom.model.Infrastructure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfrastructureRepository extends JpaRepository<Infrastructure, Long> {
}
