package com.car.Controller;


import com.car.service.CarDto;
import com.car.rest.RestCar;
import com.car.service.CarService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(path = "/")
public class CarRestController {

    @Autowired
    CarService carService;

    @GetMapping(path = "/test")
    @ResponseBody
    String test() {
        return "Hello!";
    }

    @GetMapping(path = "/feed/all")
    @ResponseBody
    List<CarDto> getAll(){
        return carService.feedAll();
    }

    //@GetMapping(path = "/feed")
    //@ResponseBody
    //List<CarDto> getAll(){        return carService.feedAll();    }

    @PostMapping(path = "/MyCar")
    @ResponseBody
    public ResponseEntity create(HttpServletRequest request, @RequestBody @NotNull RestCar message) throws Exception {
        if(message.getType() == null || message.getCarEngineSize() == null || message.getMaxNumberOfPassengers()== null || message.getCarManufactureYear()==null) {
            return new ResponseEntity(new EmptyJsonResponse(), HttpStatus.BAD_REQUEST);
        }


        if (!carService.create(message)) {
           throw new Exception();
        }
        return new ResponseEntity(new EmptyJsonResponse(), HttpStatus.OK);
    }

    @DeleteMapping(path = "/MyCar")
    @ResponseBody
    public ResponseEntity  delete(HttpServletRequest request, @RequestBody @NotNull RestCar message) throws Exception {
        if(message.getType() == null ) {
            throw new RuntimeException("Please specify which car_type you wish to delete");
        }
        carService.delete(message);

        return new ResponseEntity(new EmptyJsonResponse(), HttpStatus.OK);
    }

    @PutMapping(path = "/MyCar")
    @ResponseBody
    public ResponseEntity  put(HttpServletRequest request, @RequestBody @NotNull RestCar message) throws Exception {
        if(message.getType() == null ) {
            throw new RuntimeException("Please specify which car_type you wish to update");
        }
        if (!carService.update(message)) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST );
        }
        return new ResponseEntity(new EmptyJsonResponse(), HttpStatus.OK);
    }
}
