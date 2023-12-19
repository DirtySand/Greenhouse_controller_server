package org.jakub.greenhousecontrollerserver.repository;

import org.jakub.greenhousecontrollerserver.model.ParametersDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParametersRepository extends JpaRepository<ParametersDAO, UUID> {
    public ParametersDAO findFirstBySetDateTime();
}
