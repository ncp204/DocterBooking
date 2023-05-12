package vn.edu.nlu.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateBooking;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateENd;
    private String status;
    @ManyToOne(targetEntity = Doctor.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "doctorId",referencedColumnName = "id")
    private Doctor doctor;
    @ManyToOne(targetEntity = Patient.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "patientId",referencedColumnName = "id")

    private Patient patient;
}
