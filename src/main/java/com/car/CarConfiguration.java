package com.car;

import com.car.Controller.CarRestController;
import com.car.db.CarEntity;
import com.car.db.CarRepository;
import com.car.service.CarService;
import com.car.service.CarServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;


@Configuration
//@ComponentScans(basePackages = "com.car")
public class CarConfiguration {
    @Bean
    CarServiceImpl carService(){
        return new CarServiceImpl();
    }

    @Bean
    CarEntity carEntity(){
        return new CarEntity();
    }

    @Bean
    CarRestController carRestController(){
        return new CarRestController();
    }
}
