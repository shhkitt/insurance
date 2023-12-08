package shhkitt.rschir.kr.insurance.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shhkitt.rschir.kr.insurance.mapper.InsuranceMapper;
import shhkitt.rschir.kr.insurance.models.dto.ClinicDto;
import shhkitt.rschir.kr.insurance.models.entity.Clinic;
import shhkitt.rschir.kr.insurance.repository.ClinicRepository;
import shhkitt.rschir.kr.insurance.service.ClinicService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClinicServiceImpl implements ClinicService {

    private final ClinicRepository clinicRepository;
    private final InsuranceMapper mapper;

    @Override
    public List<ClinicDto> findAll() {
        return mapper.mapAsList(clinicRepository.findAll(), ClinicDto.class);
    }

    @Override
    public ClinicDto findById(Long id) {
        return mapper.map(clinicRepository.getById(id), ClinicDto.class);
    }

    @Override
    public void create(ClinicDto clinicDto) {
        clinicRepository.save(mapper.map(clinicDto, Clinic.class));
    }

    @Override
    public void update(ClinicDto clinicDto) {
        clinicRepository.save(mapper.map(clinicDto, Clinic.class));
    }

    @Override
    public void delete(Long id) {
        clinicRepository.deleteById(id);
    }
}
