package pl.igor.demo.model;

public class Car {
    private String name;
    private String model;
    private long price;
    private long id;

    public Car(String name, String model, long price, long id) {
        this.name = name;
        this.model = model;
        this.price = price;
        this.id = id;
    }

    public Car() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", id=" + id +
                '}';
    }
}
