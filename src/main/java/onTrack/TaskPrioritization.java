package onTrack;


import onTrack.models.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskPrioritization {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void prioritizeTask(Task task, int priority) {
        tasks.remove(task);
        tasks.add(priority, task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public List<Task> getTasksSortedByPriority() {
        List<Task> sortedTasks = new ArrayList<>(tasks);
        sortedTasks.sort((task1, task2) -> Integer.compare(tasks.indexOf(task1), tasks.indexOf(task2)));
        return sortedTasks;
    }

    public void sortTasksByPriority() {
        tasks.sort((task1, task2) -> Integer.compare(tasks.indexOf(task1), tasks.indexOf(task2)));
    }
}
