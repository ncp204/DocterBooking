package vn.edu.nlu.payload.respose;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponse {
    private Date dateBooking;
    private Date dateEnd;
}
