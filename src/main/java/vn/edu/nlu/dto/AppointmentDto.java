package vn.edu.nlu.dto;

import lombok.*;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentDto {
    private int id;
    private String patientName;
    private String patientGender;
    private String patientPhone;
    private String patientEmail;
    private Date dateBooking;
    private Date dateEnd;
    private int timeBooking;
    private int timeEnd;
    private String status;
    private int doctor_id;
    private int patient_id;
    private String description;
}
