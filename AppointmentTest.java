import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {

    @Test
    public void testValidAppointment() {
        Appointment appointment = new Appointment("123456", new Date(System.currentTimeMillis() + 10000), "Doctor visit");
        assertEquals("123456", appointment.getAppointmentId());
        assertEquals("Doctor visit", appointment.getDescription());
    }

    @Test
    public void testInvalidAppointmentId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, new Date(), "Valid description");
        });
    }

    @Test
    public void testPastAppointmentDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123456", new Date(System.currentTimeMillis() - 10000), "Description");
        });
    }

    @Test
    public void testLongDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123456", new Date(), "This description is way too long and exceeds 50 characters.");
        });
    }
}
