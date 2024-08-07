import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskTracker taskTracker = new TaskTracker();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("1.Add Task");
            System.out.println("2.View task");


            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    System.out.println("Enter task title");
                    String title = scanner.nextLine();
                    System.out.println("Enter task description");
                    String description = scanner.nextLine();
                    taskTracker.addTask(title,description);
                    taskTracker.saveTask("task.dat");
                    break;
                    case 2:
                        taskTracker.loadTask("task.dat");
                        taskTracker.viewTask();
                        break;
            }
        }
    }
}