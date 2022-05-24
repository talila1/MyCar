package com.car.service;

import com.car.rest.RestCar;

import java.util.List;

public interface CarService {

    //List<CarDto> feed ();
    List<CarDto> feedAll ();
    boolean create (RestCar message);
    boolean delete(RestCar message) throws Exception;
    boolean update(RestCar message) throws Exception;

}
