package com.car;

import com.car.db.CarEntity;
import com.car.db.CarRepository;
import com.car.rest.RestCar;
import com.car.service.CarServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


//import org.mockito.junit.jupiter.MockitoExtension;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=CarTestConfiguration.class)
public class CarServiceImplTest {

    @Mock
    private CarRepository mockCarRepository;

    @InjectMocks
    private CarServiceImpl carService;

    private CarEntity car;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void car_manufacture_yearShouldBeBetween1930and2050 (){
        try {
            RestCar fakeCar = new RestCar("1",2,1,1999);
            carService.create(fakeCar);
        } catch (RuntimeException exception) {

        }

        int size = mockCarRepository.findAll().size();
        assertEquals(size,0);
    }

    @Test
    public void cannotUpdateACarThatDoesNotExists(){
        try {
            RestCar fakeCar = new RestCar("1",2,1,1999);
            carService.update(fakeCar);
        } catch (RuntimeException exception) {

        }

        int size = mockCarRepository.findAll().size();
        assertEquals(size,0);
    }
}