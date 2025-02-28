import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class AppointmentServiceTest {

    @Test
    public void testAddAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment("123456", new Date(System.currentTimeMillis() + 10000), "Meeting");

        service.addAppointment(appointment);
        assertEquals(appointment, service.getAppointment("123456"));
    }

    @Test
    public void testAddDuplicateAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment("123456", new Date(System.currentTimeMillis() + 10000), "Meeting");

        service.addAppointment(appointment);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(appointment);
        });
    }

    @Test
    public void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment("123456", new Date(System.currentTimeMillis() + 10000), "Meeting");

        service.addAppointment(appointment);
        service.deleteAppointment("123456");
        assertNull(service.getAppointment("123456"));
    }

    @Test
    public void testDeleteNonExistentAppointment() {
        AppointmentService service = new AppointmentService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("nonexistent");
        });
    }
}
