package nl.codegorilla;

public class StelendeStudent extends Student {
    public StelendeStudent(String name, Transport transport, boolean thuisLeren) {
        super(name, transport, thuisLeren);
    }

    @Override
    protected void spend(int amount) {
        // stelen is gratis
    }

    public void inbreken() {
        money += 100;
    }
}

