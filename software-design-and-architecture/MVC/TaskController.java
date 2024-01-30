//Egemen BALLI 18 Dec 2023
import java.util.Scanner;

public class TaskController {
    private TaskModel model;
    private TaskView view;
    private Scanner scanner = new Scanner(System.in);

    public TaskController(TaskModel model, TaskView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        int choice;
        do {
            view.displayMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    markTask();
                    break;
            }

        } while (choice != 4);
        System.out.println("Exiting...");
    }

    public void addTask() {
        System.out.print("Enter task description: ");
        scanner.nextLine();
        String description = scanner.nextLine();
        model.addTask(description);
    }

    public void viewTasks() {
        view.displayTasks(model.getTasks());
    }

    public void markTask() {
        System.out.print("Enter task index to mark as completed: ");
        int taskIndex = scanner.nextInt() - 1;
        model.markTaskAsCompleted(taskIndex);
    }
}
