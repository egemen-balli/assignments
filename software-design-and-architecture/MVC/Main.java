//Egemen BALLI 18 Dec 2023
public class Main {
    public static void main(String[] args) {
        TaskModel model = new TaskModel();
        TaskView view = new TaskView();
        TaskController controller = new TaskController(model, view);

        controller.run();
    }
}
