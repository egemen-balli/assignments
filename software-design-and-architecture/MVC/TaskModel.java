//Egemen BALLI 18 Dec 2023
import java.util.ArrayList;
import java.util.List;

public class TaskModel {
    private List<Task> tasks;

    public TaskModel() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String name) {
        Task task = new Task(name);
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.setCompleted(true);
        }
    }
}
