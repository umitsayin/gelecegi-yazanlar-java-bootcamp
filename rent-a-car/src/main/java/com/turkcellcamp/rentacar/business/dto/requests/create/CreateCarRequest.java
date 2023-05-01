package com.turkcellcamp.rentacar.business.dto.requests.create;

import com.turkcellcamp.rentacar.common.constants.Messages;
import com.turkcellcamp.rentacar.common.constants.Regex;
import com.turkcellcamp.rentacar.common.utils.annotations.NotFutureYear;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarRequest {
    @Min(0)
    private int modelId;
    @Min(1996)
    @NotFutureYear
    private int modelYear;
    @Pattern(regexp = Regex.Plate, message = Messages.Car.PLATE_NOT_VALID)
    private String plate;
    @Min(1)
    @Max(100000)
    private double dailyPrice;
}

