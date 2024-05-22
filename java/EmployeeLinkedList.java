import java.util.LinkedList;

public class EmployeeLinkedList {
    private LinkedList<Employee> employees = new LinkedList<>();

    public void add(Employee employee) {
        employees.add(employee);
    }

    public void remove(Employee employee) {
        employees.remove(employee);
    }

    public void display() {
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
