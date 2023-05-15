package vn.edu.nlu.payload.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class AppointmentRequest {
    private int id;
    private Date dateBooking;
}
