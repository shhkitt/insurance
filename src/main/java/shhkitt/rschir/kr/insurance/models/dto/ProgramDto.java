package shhkitt.rschir.kr.insurance.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shhkitt.rschir.kr.insurance.models.InsuranceType;

import java.math.BigInteger;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgramDto {

    private Long id;
    private InsuranceType type;
    private String name;
    private BigInteger length;
    private String description;
    private BigInteger price;

}
