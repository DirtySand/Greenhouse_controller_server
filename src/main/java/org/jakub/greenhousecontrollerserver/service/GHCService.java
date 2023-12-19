package org.jakub.greenhousecontrollerserver.service;

import org.jakub.greenhousecontrollerserver.model.CollectedDataDAO;
import org.jakub.greenhousecontrollerserver.model.ParametersDAO;
import org.jakub.greenhousecontrollerserver.repository.CollectedDataRepository;
import org.jakub.greenhousecontrollerserver.repository.ParametersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class GHCService {

    private ParametersRepository parametersRepository;
    private CollectedDataRepository collectedDataRepository;

    public ResponseEntity<Object> saveCollectedData(CollectedDataDAO collectedDataDAO) {
        this.collectedDataRepository.save(collectedDataDAO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ParametersDAO getParametersToSet() {
        return this.parametersRepository.findFirstBySetDateTime();
    }

    public ResponseEntity setParameters(Long setTemperatureInside, Integer setStartLightHour, Integer setEndLightHour) {
        ParametersDAO parametersDAO = ParametersDAO.builder()
                .parametersId(UUID.randomUUID())
                .temperatureInside(setTemperatureInside)
                .setDateTime(LocalDateTime.now())
                .startLightHour(setStartLightHour)
                .endLightHour(setEndLightHour)
                .build();
        this.parametersRepository.save(parametersDAO);
        return new ResponseEntity(HttpStatus.OK);
    }
}
