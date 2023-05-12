package vn.edu.nlu.service2.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vn.edu.nlu.entity2.Appointment;
import vn.edu.nlu.repository2.AppointmentRespostitory;

import java.util.List;

@Component
public class AppointmentService {
    @Autowired
    AppointmentRespostitory appointmentRespostitory;

    public List<Appointment> getAppointmentByDoctorId(int id){
        return  appointmentRespostitory.findByDoctor_id(id);
    }

    public List<Appointment> getAppointmentByPatientId(int id){
        return  appointmentRespostitory.findByPatient_id(id);
    }

}
