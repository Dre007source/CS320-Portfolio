package taskservice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {
    private TaskService service;

    @BeforeEach
    public void setUp() {
        service = new TaskService();
    }

    @Test
    public void testAddTask() {
        Task task = new Task("001", "Task Name", "Task Description");
        service.addTask(task);
        assertEquals(task, service.getTask("001"));
    }

    @Test
    public void testDuplicateTaskId() {
        Task task1 = new Task("001", "Task 1", "Description 1");
        service.addTask(task1);
        assertThrows(IllegalArgumentException.class, () -> service.addTask(new Task("001", "Task 2", "Description 2")));
    }

    @Test
    public void testDeleteTask() {
        Task task = new Task("002", "Another Task", "Another description");
        service.addTask(task);
        service.deleteTask("002");
        assertNull(service.getTask("002"));
    }
}
