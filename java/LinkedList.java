public class LinkedList {
    private Node head;

    // Constructor
    public LinkedList() {
        this.head = null;
    }

    private static class Node {
        Employee employee;
        Node next;

        public Node(Employee employee) {
            this.employee = employee;
            this.next = null;
        }
    }

    // adds
    public void add(Employee employee) {
        Node newNode = new Node(employee);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // removes
    public void remove(int id) {
        if (head == null) {
            return;
        }
        if (Integer.parseInt(head.employee.getId()) == id) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (Integer.parseInt(current.next.employee.getId()) == id) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
    

    // get employee based on their id (using id)
    public Employee getEmployee(int id) {
        Node current = head;
        while (current != null) {
            if (Integer.parseInt(current.employee.getId()) == id) {
                return current.employee;
            }
            current = current.next;
        }
        return null;
    }
    

    // Prints employees in teh linked list. 
    public void printEmployees() {
        Node current = head;
        while (current != null) {
            System.out.println(current.employee);
            current = current.next;
        }
    }
}
