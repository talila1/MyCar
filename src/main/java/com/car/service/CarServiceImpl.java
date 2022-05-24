package com.car.service;

import com.car.db.CarEntity;
import com.car.db.CarRepository;
import com.car.rest.RestCar;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class CarServiceImpl implements CarService {
    @Autowired
    CarRepository carRepository;

    @Override
    public List<CarDto> feedAll() {
        List <CarDto> messages = new ArrayList<>();
        List<CarEntity> carEntities =  carRepository.findAll();
        for (CarEntity carEntity : carEntities) {
            CarDto message = new CarDto(carEntity.getType(), carEntity.getCarEngineSize(),carEntity.getMaxNumberOfPassengers(),carEntity.getCarManufactureYear());
            messages.add(message);
        }
        return messages;
    }

    @Override
    public boolean create(@NotNull RestCar message) {
        if (message.getCarManufactureYear()<1930 || message.getCarManufactureYear()>2050 ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "manufacture year must be between 1930 and 2050");
        }

        CarEntity carEntity = new CarEntity();
        carEntity.setCarEngineSize(message.getCarEngineSize());
        carEntity.setType(message.getType());
        carEntity.setCarManufactureYear(message.getCarManufactureYear());
        carEntity.setMaxNumberOfPassengers(message.getMaxNumberOfPassengers());
        boolean retVal = true;
        try {
            carRepository.save(carEntity);
        } catch (Exception e) {
            retVal = false;
        }
        return retVal;
    }

    @Override
    public boolean delete(RestCar message) {
        // find
        List<CarEntity> carEntities = carRepository.findByType(message.getType());
        if (carEntities.size() == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "car type not exist");
        }
        carRepository.deleteAll(carEntities);
        return true;
    }

    public boolean update(RestCar message) {
        // find
        List<CarEntity> carEntities = carRepository.findByType(message.getType());
        if (carEntities.size() == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "car type not exist");
        }
        if (message.getCarManufactureYear()<1930 || message.getCarManufactureYear()>2050 ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "manufacture year must be between 1930 and 2050");
        }

        boolean isAllCarsUpdated = true;
        for (CarEntity car : carEntities) {
            car.setCarEngineSize(message.getCarEngineSize());
            car.setType(message.getType());
            car.setCarManufactureYear(message.getCarManufactureYear());
            car.setMaxNumberOfPassengers(message.getMaxNumberOfPassengers());
            try {
                carRepository.saveAndFlush(car);
            }catch (Exception exception) {
                isAllCarsUpdated = false;
            }
        }
        return isAllCarsUpdated;
    }

    // @Override
   // public List<CarDto> feed() {
    //    List <CarDto> messages = new ArrayList<>();
    //    CarEntity carEntity =  carRepository.findById();
    //    CarDto message = new CarDto(carEntity.getType(), carEntity.getCarEngineSize(),carEntity.getMaxNumberOfPassengers(),carEntity.getCarManufactureYear());
    //    messages.add(message);

        //return messages;
  //  }
}
