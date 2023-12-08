package shhkitt.rschir.kr.insurance.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shhkitt.rschir.kr.insurance.mapper.InsuranceMapper;
import shhkitt.rschir.kr.insurance.models.dto.ContractDto;
import shhkitt.rschir.kr.insurance.models.entity.Contract;
import shhkitt.rschir.kr.insurance.repository.ContractRepository;
import shhkitt.rschir.kr.insurance.service.ContractService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;
    private final InsuranceMapper mapper;

    @Override
    public List<ContractDto> findAll() {
        return mapper.mapAsList(contractRepository.findAll(), ContractDto.class);
    }

    @Override
    public ContractDto findById(Long id) {
        return mapper.map(contractRepository.getById(id), ContractDto.class);
    }

    @Override
    public List<ContractDto> findByInsured(Long insuredId) {
        return mapper.mapAsList(contractRepository.findAllByInsuredId(insuredId), ContractDto.class);
    }

    @Override
    public void create(ContractDto contractDto) {
        contractRepository.save(mapper.map(contractDto, Contract.class));
    }

    @Override
    public void update(ContractDto contractDto) {
        contractRepository.save(mapper.map(contractDto, Contract.class));
    }

    @Override
    public void delete(Long id) {
        contractRepository.deleteById(id);

    }
}
