import java.util.HashMap;

public class EmployeeHashTable {
    private HashMap<String, Employee> table = new HashMap<>();

    public void add(Employee employee) {
        table.put(employee.getId(), employee);
    }

    public Employee get(int id) {
        return table.get(Integer.toString(id));
    }    

    public void remove(String id) {
        table.remove(id);
    }
    
    public void display() {
        for (Employee employee : table.values()) {
            System.out.println(employee);
        }
    }

}
