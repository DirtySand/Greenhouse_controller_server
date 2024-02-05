package org.jakub.greenhousecontrollerserver.repository;

import lombok.NoArgsConstructor;
import org.jakub.greenhousecontrollerserver.model.CollectedDataDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CollectedDataRepository extends CrudRepository<CollectedDataDAO, UUID> {
}
