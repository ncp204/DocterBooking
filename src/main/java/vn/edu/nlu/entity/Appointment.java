package vn.edu.nlu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@Builder
public class Appointment {
    @Transient
    public final static int DURATION = 1;//hours

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String patientName;
    private String patientGender;
    private String patientPhone;
    private String patientEmail;
    @Temporal(TemporalType.DATE)
    private Date dateBooking;
    private int timeBooking;
    @Temporal(TemporalType.DATE)
    private Date dateEnd;
    private int timeEnd;
    private String status;
    @ManyToOne(targetEntity = Doctor.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "doctorId",referencedColumnName = "id")
    private Doctor doctor;
    @ManyToOne(targetEntity = Patient.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "patientId",referencedColumnName = "id")

    private Patient patient;

    private String description;
}
