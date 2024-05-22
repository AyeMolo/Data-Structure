import java.util.HashMap;

public class HashTable {
    private HashMap<String, Employee> table;

    public HashTable() {
        table = new HashMap<String, Employee>();
    }

    public void addEmployee(Employee employee) {
        table.put(employee.getId(), employee);
    }

    public Employee getEmployee(String id) {
        return table.get(id);
    }

}
