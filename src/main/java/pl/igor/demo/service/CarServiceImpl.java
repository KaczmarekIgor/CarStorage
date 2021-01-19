package pl.igor.demo.service;

import org.springframework.stereotype.Service;
import pl.igor.demo.model.Car;

import java.util.ArrayList;
import java.util.List;


@Service
public class CarServiceImpl implements CarService {

    private List<Car> carList;


    public CarServiceImpl() {
        this.carList = new ArrayList<>();
        initCar();
    }

    @Override
    public List<Car> getCarList() {
        return carList;
    }

    @Override
    public List<Car> initCar() {
        carList.add(new Car("Audi", "A3", 12000, 1));
        carList.add(new Car("BMW", "X6", 32222, 2));
        carList.add(new Car("Audi", "A3", 33333331, 3));
        return carList;
    }

    @Override
    public List<Car> clearCarsPage() {
        carList.clear();
        return carList;
    }

    @Override
    public Car getCarById(long id) {
        Car searchCar = carList.stream()
                .filter(car -> car.getId() == id).findFirst().get();
        return searchCar;
    }

    @Override
    public Car addCar(Car car) {
        carList.add(car);
        return car;
    }

    //wykorzystujemy metoda getCarById.ustawiamy cene i zwracamy liste juz z poprawiona cena do danego auto !!! :D
    @Override
    public List<Car> modifyPriceOfCar(long price, long id) {
        getCarById(id).setPrice(price);
        return carList;
    }

    @Override
    public List<Car> deleteCarById(long id) {
        Car carToDelete = carList.stream()
                .filter(car -> car.getId() == id)
                .findFirst()
                .get();
        carList.remove(carToDelete);
        return carList;

    }

}
