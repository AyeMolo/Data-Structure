import java.util.LinkedList;
import java.util.Queue;

public class TaskQueue {
    private Queue<Task> queue = new LinkedList<>();

    public void add(Task task) {
        queue.add(task);
    }

    public Task poll() {
        return queue.poll();
    }

    public void display() {
        for (Task t : queue) {
            System.out.println(t);
        }
    }
}
