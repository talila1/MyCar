package com.car.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestCar {
     private String type;
     private Integer maxNumberOfPassengers;
     private Integer carEngineSize;
     private Integer carManufactureYear;
}
