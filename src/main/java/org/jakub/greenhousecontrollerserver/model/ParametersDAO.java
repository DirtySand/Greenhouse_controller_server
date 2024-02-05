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
@Table(name = "parameters")
public class ParametersDAO {
    @Id
    @Column(name = "id")
    private UUID parametersId;
    @Column(name = "set_date")
    private LocalDateTime dateTime;
    @Column(name = "temperature_inside")
    private Float temperatureInside;
}
