package org.jakub.greenhousecontrollerserver.repository;

import org.jakub.greenhousecontrollerserver.model.CollectedDataDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CollectedDataRepository extends JpaRepository<CollectedDataDAO, UUID> {
    
}
