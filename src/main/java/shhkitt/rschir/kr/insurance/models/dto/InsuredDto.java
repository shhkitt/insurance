package shhkitt.rschir.kr.insurance.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsuredDto {
    private Long id;

    private String firstName;
    private String lastName;
    private String patronymic;

    private String number;
    private String email;

    private LocalDate birthDate;

    private ClientDto clientDto;

    private String login;
    private String password;

    private List<ContractDto> contracts;

}
