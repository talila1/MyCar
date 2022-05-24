package com.car.db;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "car")
@Data
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    public Integer id;

    @Column(name ="type")
    private String type;

    @Column(name = "maxNumberOfPassengers")
    private Integer maxNumberOfPassengers;

    @Column(name = "carEngineSize")
    private Integer carEngineSize;

    @Column(name = "carManufactureYear")
    private Integer carManufactureYear;

}



