package com.car;

import com.car.service.CarService;
import com.car.service.CarServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("IT")
public class CarTestITConfiguration {

    @Bean
    CarServiceImpl carService(){
        return new CarServiceImpl() ;
    }

}
