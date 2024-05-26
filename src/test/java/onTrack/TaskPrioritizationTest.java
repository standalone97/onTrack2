package onTrack;

import static org.junit.Assert.assertEquals;

import onTrack.models.Task;
import org.junit.Test;

import java.util.List;

public class TaskPrioritizationTest {

    @Test
    public void testAddTask() {
        TaskPrioritization prioritization = new TaskPrioritization();
        Task task = new Task("1", "Task 1");

        prioritization.addTask(task);

        List<Task> tasks = prioritization.getTasks();

        assertEquals(1, tasks.size());
        assertEquals("Task 1", tasks.get(0).getContent());
    }

    @Test
    public void testPrioritizeTaskToTop() {
        TaskPrioritization prioritization = new TaskPrioritization();
        Task task1 = new Task("1", "Task 1");
        Task task2 = new Task("2", "Task 2");

        prioritization.addTask(task1);
        prioritization.addTask(task2);

        prioritization.prioritizeTask(task1, 0);

        List<Task> tasks = prioritization.getTasksSortedByPriority();

        assertEquals("Task 1", tasks.get(0).getContent());
    }

    @Test
    public void testPrioritizeTaskToMiddle() {
        TaskPrioritization prioritization = new TaskPrioritization();
        Task task1 = new Task("1", "Task 1");
        Task task2 = new Task("2", "Task 2");
        Task task3 = new Task("3", "Task 3");

        prioritization.addTask(task1);
        prioritization.addTask(task2);
        prioritization.addTask(task3);

        prioritization.prioritizeTask(task1, 1);

        List<Task> tasks = prioritization.getTasksSortedByPriority();

        assertEquals("Task 2", tasks.get(0).getContent());
        assertEquals("Task 1", tasks.get(1).getContent());
        assertEquals("Task 3", tasks.get(2).getContent());
    }

    @Test
    public void testRetrieveTasksSortedByPriority() {
        TaskPrioritization prioritization = new TaskPrioritization();
        Task task1 = new Task("1", "Task 1");
        Task task2 = new Task("2", "Task 2");
        Task task3 = new Task("3", "Task 3");

        prioritization.addTask(task1);
        prioritization.addTask(task2);
        prioritization.addTask(task3);

        prioritization.prioritizeTask(task1, 2);
        prioritization.prioritizeTask(task2, 0);
        prioritization.prioritizeTask(task3, 1);

        List<Task> tasks = prioritization.getTasksSortedByPriority();

        assertEquals("Task 2", tasks.get(0).getContent());
        assertEquals("Task 3", tasks.get(1).getContent());
        assertEquals("Task 1", tasks.get(2).getContent());
    }

    @Test
    public void testSortTasksByPriority() {
        TaskPrioritization prioritization = new TaskPrioritization();
        Task task1 = new Task("1", "Task 1");
        Task task2 = new Task("2", "Task 2");
        Task task3 = new Task("3", "Task 3");

        prioritization.addTask(task1);
        prioritization.addTask(task2);
        prioritization.addTask(task3);

        prioritization.prioritizeTask(task1, 2);
        prioritization.prioritizeTask(task2, 0);
        prioritization.prioritizeTask(task3, 1);

        prioritization.sortTasksByPriority();
        List<Task> tasks = prioritization.getTasks();

        assertEquals("Task 2", tasks.get(0).getContent());
        assertEquals("Task 3", tasks.get(1).getContent());
        assertEquals("Task 1", tasks.get(2).getContent());
    }
}