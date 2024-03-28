package nl.codegorilla;

public class Student {
    int kennis = 0;
    String name;
    Transport transport;
    private final boolean thuisLeren;
    int money = 0;

    public Student(String name, Transport transport, boolean thuisLeren) {
        this.name = name;
        this.transport = transport;
        this.thuisLeren = thuisLeren;
    }

    public void work() {
        fuelIfNeeded();
        transport.drive("Werk");
        money += 20;
        transport.drive("Thuis");
    }

    public void leer() {
        if (thuisLeren) {
            kennis += 2;
            return;
        }
        fuelIfNeeded();
        transport.drive("codeGorilla");
        kennis += 2;
        transport.drive("Thuis");
    }

    private void fuelIfNeeded() {
        spend(transport.fuelIfNeeded() * World.FUEL_PRICE);
    }

    protected void spend(int amount) {
        money -= amount;
        if (money < 0) {
            throw new RuntimeException("Geen geld :'(");
        }
        if (amount > 0) {
//            System.out.println("%s geeft € %d uit".formatted(name, amount));
        }
    }
}
