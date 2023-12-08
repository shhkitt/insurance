package shhkitt.rschir.kr.insurance.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shhkitt.rschir.kr.insurance.mapper.InsuranceMapper;
import shhkitt.rschir.kr.insurance.models.dto.InsuredDto;
import shhkitt.rschir.kr.insurance.models.entity.Insured;
import shhkitt.rschir.kr.insurance.repository.InsuredRepository;
import shhkitt.rschir.kr.insurance.service.InsuredService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InsuredServiceImpl implements InsuredService {

    private final InsuredRepository insuredRepository;
    private final InsuranceMapper mapper;

    @Override
    public List<InsuredDto> findAll() {
        return mapper.mapAsList(insuredRepository.findAll(), InsuredDto.class);
    }

    @Override
    public InsuredDto findById(Long id) {
        return mapper.map(insuredRepository.getById(id), InsuredDto.class);
    }

    @Override
    public List<InsuredDto> findByClient(Long clientId) {
        return mapper.mapAsList(insuredRepository.findAllByClientId(clientId), InsuredDto.class);
    }

    @Override
    public void create(InsuredDto insuredDto) {
        insuredRepository.save(mapper.map(insuredDto, Insured.class));
    }

    @Override
    public void update(InsuredDto insuredDto) {
        insuredRepository.save(mapper.map(insuredDto, Insured.class));
    }

    @Override
    public void delete(Long id) {
        insuredRepository.deleteById(id);
    }
}
