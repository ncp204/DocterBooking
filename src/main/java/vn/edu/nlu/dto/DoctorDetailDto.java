package vn.edu.nlu.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorDetailDto {
    private String user_name;
    private String phone;
    private String email;
    private String specialize;
    private String degree;
}
