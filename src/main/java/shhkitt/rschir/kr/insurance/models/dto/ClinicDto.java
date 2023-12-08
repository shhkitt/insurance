package shhkitt.rschir.kr.insurance.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClinicDto {

    private Long id;
    private String name;
    private String address;

}
