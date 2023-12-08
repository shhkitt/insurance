package shhkitt.rschir.kr.insurance.service;


import shhkitt.rschir.kr.insurance.models.dto.ClinicDto;

import java.util.List;

public interface ClinicService {

    List<ClinicDto> findAll();

    ClinicDto findById(Long id);

    void create(ClinicDto clinicDto);

    void update(ClinicDto clinicDto);
    void delete(Long id);

}
