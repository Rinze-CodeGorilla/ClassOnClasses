package nl.codegorilla;

public class Benenwagen implements Transport {
    private String location = "Thuis";
    @Override
    public void drive(String destination) {
        location = destination;
    }

    @Override
    public int fuelIfNeeded() {
        return 0;
    }
}
