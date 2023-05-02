package com.turkcellcamp.rentacar.business.dto.responses.create;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateMaintenanceResponse {
    private int id;
    private int carId;
    private String information;
    private boolean isCompleted;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @Override
    public String toString() {
        return "CreateMaintenanceResponse{" +
                "id=" + id +
                ", carId=" + carId +
                ", information='" + information + '\'' +
                ", isCompleted=" + isCompleted +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}

