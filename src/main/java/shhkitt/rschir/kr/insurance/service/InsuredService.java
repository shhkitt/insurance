package shhkitt.rschir.kr.insurance.service;

import shhkitt.rschir.kr.insurance.models.dto.ContractDto;
import shhkitt.rschir.kr.insurance.models.dto.InsuredDto;

import java.util.List;

public interface InsuredService {


    List<InsuredDto> findAll();

    InsuredDto findById(Long id);

    List<InsuredDto> findByClient(Long clientId);

    void create(InsuredDto insuredDto);

    void update(InsuredDto insuredDto);

    void delete(Long id);
}
