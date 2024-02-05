package org.jakub.greenhousecontrollerserver.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.jakub.greenhousecontrollerserver.model.CollectedDataDAO;
import org.jakub.greenhousecontrollerserver.model.ParametersDAO;
import org.jakub.greenhousecontrollerserver.service.GHCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Controller
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/ghc/")
public class GHCController {

    @Autowired
    private GHCService ghcService;

    @GetMapping("parameters")
    public ResponseEntity getParameters() {
        ParametersDAO parametersDAO;
        HttpHeaders responseHeader = new HttpHeaders();
        if(this.ghcService.getParametersToSet() == null){
            responseHeader.set("temperatureInside", "16");
            return ResponseEntity.ok().body(responseHeader);
        }
        parametersDAO = this.ghcService.getParametersToSet();
        responseHeader.set("temperatureInside", parametersDAO.getTemperatureInside().toString());
        return ResponseEntity.ok().body(responseHeader);
    }

    @PostMapping("parameters/{setTemperatureInside}")
    public ResponseEntity setParameters(@PathVariable Float setTemperatureInside) {
        return this.ghcService.setParameters(setTemperatureInside);
    }

    @PostMapping("save-data")
    public ResponseEntity saveDataFromGreenhouse(@RequestParam Float measuredTInside, @RequestParam Float measuredTOutside,
                                                 @RequestParam Float measuredHInside, @RequestParam Float measuredHOutside,
                                                 @RequestParam Boolean lightState, @RequestParam Boolean windowState,
                                                 @RequestParam Boolean heaterState, @RequestParam int soilMoisture) {
        CollectedDataDAO collectedDataDAO = CollectedDataDAO.builder()
                .dataId(UUID.randomUUID())
                .collectionDateAndTime(LocalDateTime.now())
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
