import java.util.EmptyStackException;

public class EmployeeStack  {
    private Node top;

    public EmployeeStack() {
        this.top = null;
    }

    private static class Node {
        Employee employee;
        Node next;

        public Node(Employee employee) {
            this.employee = employee;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(Employee employee) {
        Node newNode = new Node(employee);
        newNode.next = top;
        top = newNode;
    }

    public Employee pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Employee poppedEmployee = top.employee;
        top = top.next;
        return poppedEmployee;
    }

    public Employee peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.employee;
    }
}
