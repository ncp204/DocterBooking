package vn.edu.nlu.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BookingRequest {
    private int doctorId;
    private int patientId;
    private String fullName;
    private String gender;
    private String phone;
    private String email;
    private Date dateBooking;
    private int timeBooking;
    private String description;
}
