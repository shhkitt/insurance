package shhkitt.rschir.kr.insurance.service;


import shhkitt.rschir.kr.insurance.models.dto.ContractDto;

import java.util.List;

public interface ContractService {

    List<ContractDto> findAll();

    ContractDto findById(Long id);

    List<ContractDto> findByInsured(Long insuredId);

    void create(ContractDto contractDto);

    void update(ContractDto contractDto);

    void delete(Long id);

}
