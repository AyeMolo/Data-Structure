import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeLinkedList employeeList = new EmployeeLinkedList();
        EmployeeStack undoStack = new EmployeeStack();
        EmployeeStack redoStack = new EmployeeStack();
        TaskQueue taskQueue = new TaskQueue();
        EmployeeHashTable employeeTable = new EmployeeHashTable();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Assign Task");
            System.out.println("5. View Tasks");
            System.out.println("6. Undo");
            System.out.println("7. Redo");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    name = scanner.nextLine();
                    System.out.print("Enter Employee Position: ");
                    String position = scanner.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    double salary = scanner.nextDouble();
                    Employee employee = new Employee(id, name, position, salary);
                    employeeList.add(employee);
                    employeeTable.add(employee);
                    undoStack.push(employee);
                    redoStack = new EmployeeStack(); 
                    break;
                case 2:
                    employeeList.display();
                    break;
                case 3:
                    System.out.print("Enter Employee ID: ");
                    id = scanner.nextInt();
                    Employee foundEmployee = employeeTable.get(id);
                    if (foundEmployee != null) {
                        System.out.println("Employee Found: " + foundEmployee);
                    } else {
                        System.out.println("Employee Not Found");
                    }
                    break;
                case 4:
                    System.out.print("Enter Task ID: ");
                    String taskId = scanner.nextLine();
                    System.out.print("Enter Task Description: ");
                    String description = scanner.nextLine();
                    Task task = new Task(taskId, description);
                    taskQueue.add(task);
                    System.out.println("Task Assigned: " + task);
                    break;
                case 5:
                    taskQueue.display();
                    break;
                case 6:
                    Employee undoEmployee = undoStack.pop();
                    if (undoEmployee != null) {
                        employeeList.remove(undoEmployee);
                        employeeTable.remove(undoEmployee.getId());
                        redoStack.push(undoEmployee);
                        System.out.println("Undo: Removed " + undoEmployee);
                    } else {
                        System.out.println("Nothing to undo");
                    }
                    break;
                case 7:
                    Employee redoEmployee = redoStack.pop();
                    if (redoEmployee != null) {
                        employeeList.add(redoEmployee);
                        employeeTable.add(redoEmployee);
                        undoStack.push(redoEmployee);
                        System.out.println("Redo: Added " + redoEmployee);
                    } else {
                        System.out.println("Nothing to redo");
                    }
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}