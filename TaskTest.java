package taskservice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void testTaskCreation() {
        Task task = new Task("001", "Test Task", "This is a test description");
        assertEquals("001", task.getTaskId());
        assertEquals("Test Task", task.getName());
        assertEquals("This is a test description", task.getDescription());
    }

    @Test
    public void testInvalidTaskId() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "Task", "Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "Task", "Description"));
    }
}
