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
@Table(name = "collected-data")
public class CollectedDataDAO {
    @Id
    @Column(name = "id")
    private UUID dataId;
    @Column(name = "date-and-time")
    private LocalDateTime collectionDateAndTime;
    @Column(name = "temperature-inside")
    private Long temperatureInside;
    @Column(name = "temperature-outside")
    private Long temperatureOutside;
    @Column(name = "humidity-inside")
    private Long humidityInside;
    @Column(name = "humidity-outside")
    private Long humidityOutside;
    @Column(name = "soil-moisture")
    private Long soilMoisture;
    @Column(name = "heater-state")
    private Boolean heaterState;
    @Column(name = "window-state")
    private Boolean windowState;
    @Column(name = "light-state")
    private Boolean lightState;
}
