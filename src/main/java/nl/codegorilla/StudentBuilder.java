package nl.codegorilla;

public class StudentBuilder {
    String name = null;
    boolean thuis = false;
    Transport transport = null;
    boolean dief = false;

    public StudentBuilder transport(Transport transport) {
        this.transport = transport;
        return this;
    }

    public StudentBuilder name(String name) {
        this.name = name;
        return this;
    }

    public StudentBuilder thuis(boolean thuis) {
        this.thuis = thuis;
        return this;
    }

    public Student build() {
        if (thuis) {
            if (dief) {
                return new StelendeStudent(name, transport, true);
            }
            return new ThuisStudent(name, transport);
        } else {
            if (dief) {
                return new StelendeStudent(name, transport, false);
            }
            return new Student(name, transport, false);
        }
    }
}
