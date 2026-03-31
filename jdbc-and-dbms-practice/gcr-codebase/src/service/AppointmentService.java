package service;
import model.Appointment;
import repository.AppointmentRepository;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class AppointmentService {

    private AppointmentRepository repo = new AppointmentRepository();

    // UC-3.1
    public boolean book(Appointment a) {

        if (!repo.isDoctorAvailable(a.getDoctorId(), a.getAppointmentDate(), a.getAppointmentTime())) {
            System.out.println("Doctor not available!");
            return false;
        }

        return repo.save(a);
    }
    // UC-3.2
    public boolean checkAvailability(int doctorId, Date date, Time time) {
        return repo.isDoctorAvailable(doctorId, date, time);
    }

    // UC-3.3
    public boolean cancel(int id) {
        return repo.cancelAppointment(id);
    }

    // UC-3.4
    public boolean reschedule(int id, int docId, Date date, Time time) {
        return repo.reschedule(id, docId, date, time);
    }

    // UC-3.5
    public List<String> getSchedule(Date date) {
        return repo.getDailySchedule(date);
    }
}