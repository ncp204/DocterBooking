package vn.edu.nlu.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Booking {
    @Transient
    public final static int DURATION = 60 * 60 * 1000;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String patientName;
    private String patientGender;
    private String patientPhone;
    private String patientEmail;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateBooking;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnd;
    private String status;
    @ManyToOne(targetEntity = Doctor.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "doctorId",referencedColumnName = "id")
    private Doctor doctor;
    @ManyToOne(targetEntity = Patient.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "patientId",referencedColumnName = "id")

    private Patient patient;

    private String description;

}