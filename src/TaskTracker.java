import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskTracker {
    private List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public void addTask(String title,String description){
        Task task = new Task(nextId++,title,description);
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    public void viewTask(){
        if(tasks.isEmpty()){
            System.out.println("No tasks found");
            return;
        }
        for(Task task : tasks){
            System.out.println(task);
        }
    }

    public void saveTask(String filename){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
            oos.writeObject(tasks);
            System.out.println("Saved tasks");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void loadTask(String filename){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
            tasks = (List<Task>) ois.readObject();
            nextId = tasks.size() +1 ;
            System.out.println("Loaded tasks");
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
