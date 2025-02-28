import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private final Map<String, Appointment> appointments = new HashMap<>();

    // Add appointment
    public void addAppointment(Appointment appointment) {
        if (appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment ID must be unique.");
        }
        appointments.put(appointment.getAppointmentId(), appointment);
    }

    // Delete appointment
    public void deleteAppointment(String appointmentId) {
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment not found.");
        }
        appointments.remove(appointmentId);
    }

    // Retrieve appointment (for testing purposes)
    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
}
