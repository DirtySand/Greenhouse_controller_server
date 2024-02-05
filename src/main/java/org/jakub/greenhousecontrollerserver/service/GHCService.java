package org.jakub.greenhousecontrollerserver.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.jakub.greenhousecontrollerserver.model.CollectedDataDAO;
import org.jakub.greenhousecontrollerserver.model.ParametersDAO;
import org.jakub.greenhousecontrollerserver.repository.CollectedDataRepository;
import org.jakub.greenhousecontrollerserver.repository.ParametersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class GHCService {

    @Autowired
    private ParametersRepository parametersRepository;
    @Autowired
    private CollectedDataRepository collectedDataRepository;

    public ResponseEntity<Object> saveCollectedData(CollectedDataDAO collectedDataDAO) {
        this.collectedDataRepository.save(collectedDataDAO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ParametersDAO getParametersToSet() {
        ParametersDAO parametersDAO;
        try{
            parametersDAO = this.parametersRepository.findFirstByOrderByDateTimeDesc();
        }catch(Exception e){
            return ParametersDAO.builder()
                    .temperatureInside(20F)
                    .build();
        }
        return parametersDAO;
    }

    public ResponseEntity setParameters(Float setTemperatureInside) {
        ParametersDAO parametersDAO = ParametersDAO.builder()
                .parametersId(UUID.randomUUID())
                .temperatureInside(setTemperatureInside)
                .dateTime(LocalDateTime.now())
                .build();
        this.parametersRepository.save(parametersDAO);
        return new ResponseEntity(HttpStatus.OK);
    }
}
