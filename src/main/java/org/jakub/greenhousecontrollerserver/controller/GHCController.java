package org.jakub.greenhousecontrollerserver.controller;

import org.jakub.greenhousecontrollerserver.model.CollectedDataDAO;
import org.jakub.greenhousecontrollerserver.model.ParametersDAO;
import org.jakub.greenhousecontrollerserver.service.GHCService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Controller
@RequestMapping("/ghc/")
public class GHCController {

    private GHCService ghcService;

    @GetMapping("parameters")
    public ResponseEntity getParameters() {
        ParametersDAO parametersDAO = this.ghcService.getParametersToSet();
        return new ResponseEntity<>(parametersDAO.getTemperatureInside(), HttpStatus.OK);
    }

    @PutMapping("parameters/{setTemperatureInside}/{setStartLightHour}/{setEndLightHour}")
    public ResponseEntity setParameters(@PathVariable Long setTemperatureInside, @PathVariable Integer setStartLightHour, @PathVariable Integer setEndLightHour) {
        return this.ghcService.setParameters(setTemperatureInside, setStartLightHour, setEndLightHour);
    }

    @PutMapping("save-data")
    public ResponseEntity saveDataFromGreenhouse(@RequestParam LocalDateTime collectionDateAndTime, @RequestParam Long measuredTInside, @RequestParam Long measuredTOutside,
                                                 @RequestParam Long measuredHInside, @RequestParam Long measuredHOutside, @RequestParam Boolean lightState, @RequestParam Boolean windowState,
                                                 @RequestParam Boolean heaterState, @RequestParam Long soilMoisture) {
        CollectedDataDAO collectedDataDAO = CollectedDataDAO.builder()
                .dataId(UUID.randomUUID())
                .collectionDateAndTime(collectionDateAndTime)
                .temperatureInside(measuredTInside)
                .temperatureOutside(measuredTOutside)
                .humidityInside(measuredHInside)
                .humidityOutside(measuredHOutside)
                .soilMoisture(soilMoisture)
                .lightState(lightState)
                .heaterState(heaterState)
                .windowState(windowState)
                .build();
        return ghcService.saveCollectedData(collectedDataDAO);
    }
}
