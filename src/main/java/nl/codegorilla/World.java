package nl.codegorilla;

public class World {
    final public static int FUEL_PRICE = 3;

    public static void main(String[] args) {
        System.out.println("Hello world!");

        //deze studenten delen een auto
        StudentBuilder thuisBuilder = new StudentBuilder().thuis(true).transport(makeFiat());
        Student a = thuisBuilder.name("a").build();
        Student b = thuisBuilder.name("b").build();

        Student primrose = new StudentBuilder()
                .name("Primrose")
                .thuis(true)
                .transport(makeBenenwagen())
                .build();

        Transport hansCar = makeLexus();
        hansCar.drive("Thuis");
        Student hans = new Student("Hans", hansCar, false);
        Student dennis = new Student("Dennis", makeFiat(), false);
        Student boef = new StelendeStudent("Boef", makeFiat(), false);
        Student lopendeBoef = new StelendeStudent("Lopende Boef", new Benenwagen(), true);
        Student[] students = new Student[] {a,b, primrose, hans, dennis, boef, lopendeBoef};

        try {
            for (int i = 0; i < 12 * 5; i++) {
                for (Student student : students) {
                    student.leer();
                    student.work();
                    if (student instanceof StelendeStudent) {
                        StelendeStudent stelendeStudent = (StelendeStudent) student;
                        stelendeStudent.inbreken();
                    }
                }
            }
        } catch (RuntimeException e) {
            System.out.println("Er ging iets mis met het rijden van Dennis z'n auto: " + e.getMessage());
        }
        for (Student student : students) {
            printStudentStatus(student);
        }
    }

    private static void printStudentStatus(Student student) {
        System.out.println(student.name + " weet " + student.kennis + " en heeft € " + student.money);
    }

    private static Car makeFiat() {
        return new Car("Garage", 20);
    }
    private static Car makeLexus() {
        return new Car("Garage", 50);
    }
    private static Benenwagen makeBenenwagen() {
        return new Benenwagen();
    }
}

