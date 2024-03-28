package nl.codegorilla;

public class Car implements Transport {
    protected String location;
    private int fuel;
    private int maxFuel;

    public Car(String location, int fuel) {
        this.location = location;
        this.maxFuel = this.fuel = fuel;
    }

    public void drive(String destination) {
        if (fuel <= 0) {
//            System.out.println("Het is op");
            throw new RuntimeException("Geen benzine meer :(");
        }
        this.location = destination;
        this.fuel--;
    }

    public int fuel() {
        int fuelNeeded = maxFuel - fuel;
        fuel = maxFuel;
        return fuelNeeded;
    }


    public int fuelIfNeeded() {
        if (fuel < 10) {
            return fuel();
        }
        return 0;
    }


}
