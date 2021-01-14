package pl.igor.demo.service;

import pl.igor.demo.model.Car;

import java.util.List;

public interface CarService {
  /*

    modify field in existing entry

   */

    List<Car> getCarList();

    Car getCarById(long id);

    Car addCar(Car car);

  //  List<Car> modifyAllParam(Car newCar);

    List<Car> deleteCarById(long id);

    List<Car> modifyPriceOfCar(long price, long id);

    List<Car> initCar();

    List<Car> clearCarsPage();


}
