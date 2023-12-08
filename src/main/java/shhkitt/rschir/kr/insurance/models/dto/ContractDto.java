package shhkitt.rschir.kr.insurance.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;
import shhkitt.rschir.kr.insurance.models.InsurerType;
import shhkitt.rschir.kr.insurance.models.entity.Insured;
import shhkitt.rschir.kr.insurance.models.entity.Program;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractDto {

    private Long id;
    private ProgramDto program;
    private LocalDate start;
    private Insured insured;
    private InsurerType insurerType;
    private String insurer;
}
