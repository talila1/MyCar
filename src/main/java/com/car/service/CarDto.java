package com.car.service;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {

     String type;
     Integer maxNumberOfPassengers;
     Integer carEngineSize;
     Integer carManufactureYear;


}
