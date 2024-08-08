import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskTracker taskTracker = new TaskTracker();



            taskTracker.loadTask("task.dat");


            String command = args[0];

            switch(command){
                case "add":
                    if (args.length < 3){
                        System.out.println("Use: task-cli add <title> <description>");
                    }
                    String title = args[1];
                    String description = args[2];
                    taskTracker.addTask(title,description);
                    taskTracker.saveTask("task.dat");
                    break;
                    case "view":
                        if (args.length < 2){
                            System.out.println("Use: task-cli view");
                        }
                        taskTracker.loadTask("task.dat");
                        taskTracker.viewTask();
                        break;
                    case "delete":
                        if (args.length < 2){
                            System.out.println("Use: task-cli delete <id>");
                            return;
                        }
                        int deleteId = Integer.parseInt(args[1]);
                        taskTracker.deleteTask(deleteId);
                        taskTracker.saveTask("task.dat");
                        break;
                    case "updateStatus":
                        if (args.length < 3){
                            System.out.println("Use: task-cli updateStatus <id> <status>");
                            return;
                        }
                        int id = Integer.parseInt(args[1]);
                        String status = args[2];
                        taskTracker.updateStatus(id, status);
                        taskTracker.saveTask("task.dat");
                        break;

            }

    }
}