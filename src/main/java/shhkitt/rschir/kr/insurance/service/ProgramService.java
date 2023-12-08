package shhkitt.rschir.kr.insurance.service;

import shhkitt.rschir.kr.insurance.models.InsuranceType;
import shhkitt.rschir.kr.insurance.models.dto.InsuredDto;
import shhkitt.rschir.kr.insurance.models.dto.ProgramDto;

import java.util.List;


public interface ProgramService {

    List<ProgramDto> findAll();

    void create(ProgramDto programDto);

    List<ProgramDto> findByType(String type);

    ProgramDto findById(Long id);

    void update(ProgramDto programDto);

    void delete(Long id);

}
