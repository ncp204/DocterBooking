package vn.edu.nlu.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorDetailDto {
    private int id;
    private String fullName;
    private String phone;
    private String email;
    private String gender;
    private String specialize;
    private String degree;
}
