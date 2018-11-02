package personnel;

public class Main {

    public static void main(String[] args) {
        // write test code here
        Employees employees = new Employees();
        Person arto = new Person("Arto", Education.D);
        employees.add(arto);
        employees.print(Education.D);
    }
}
