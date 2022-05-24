use car;

CREATE TABLE IF NOT EXISTS `car` (
                       `id` int(11) NOT NULL AUTO_INCREMENT,
                       `type` varchar(100) DEFAULT NULL,
                       `max_number_of_passengers` int(11) DEFAULT NULL,
                       `car_engine_size` int(11) DEFAULT NULL,
                       `car_manufacture_year` int(11) DEFAULT NULL,
                       PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


