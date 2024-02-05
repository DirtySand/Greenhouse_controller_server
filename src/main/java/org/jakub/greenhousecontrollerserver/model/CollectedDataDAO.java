package org.jakub.greenhousecontrollerserver.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "collected_data")
public class CollectedDataDAO {
    @Id
    @Column(name = "id")
    private UUID dataId;
    @Column(name = "date_and_time")
    private LocalDateTime collectionDateAndTime;
    @Column(name = "temperature_inside")
    private Float temperatureInside;
    @Column(name = "temperature_outside")
    private Float temperatureOutside;
    @Column(name = "humidity_inside")
    private Float humidityInside;
    @Column(name = "humidity_outside")
    private Float humidityOutside;
    @Column(name = "soil_moisture")
    private int soilMoisture;
    @Column(name = "heater_state")
    private Boolean heaterState;
    @Column(name = "window_state")
    private Boolean windowState;
    @Column(name = "light_state")
    private Boolean lightState;
}
