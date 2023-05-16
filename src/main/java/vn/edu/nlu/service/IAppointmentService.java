package vn.edu.nlu.service;

import org.springframework.stereotype.Service;
import vn.edu.nlu.dto.AppointmentDto;
import vn.edu.nlu.entity.Appointment;
import vn.edu.nlu.payload.request.BookingRequest;
import vn.edu.nlu.payload.respose.AppointmentResponse;

import java.util.Date;
import java.util.List;

@Service
public interface IAppointmentService {
    public List<AppointmentDto> getAllListAppointment();

    public List<AppointmentDto> getListAppointmentDoctorById(int id);

    public List<AppointmentDto> getListAppointmentPatientById(int id);

    List<AppointmentResponse> getListAppointmentByDate(int id, Date date);
    public String addBooking(BookingRequest request);
}
