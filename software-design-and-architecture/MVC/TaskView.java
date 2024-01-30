//Egemen BALLI 18 Dec 2023
import java.util.List;

public class TaskView {
    public void displayMenu() {
        System.out.println("\nOptions:");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Mark Task as Completed");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public void displayTasks(List<Task> tasks) {
        System.out.println("To-Do List:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            String status = task.isCompleted() ? "[Done]" : "[Waiting]";
            System.out.println(i + 1 + ". " + status + " " + task.getDescription());
        }
    }
}
