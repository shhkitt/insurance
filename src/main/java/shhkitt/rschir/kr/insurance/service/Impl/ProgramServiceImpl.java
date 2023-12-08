package shhkitt.rschir.kr.insurance.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shhkitt.rschir.kr.insurance.mapper.InsuranceMapper;
import shhkitt.rschir.kr.insurance.models.InsuranceType;
import shhkitt.rschir.kr.insurance.models.dto.ProgramDto;
import shhkitt.rschir.kr.insurance.models.entity.Program;
import shhkitt.rschir.kr.insurance.repository.ProgramRepository;
import shhkitt.rschir.kr.insurance.service.ProgramService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProgramServiceImpl implements ProgramService {

    private final ProgramRepository programRepository;
    private final InsuranceMapper mapper;
    @Override
    public List<ProgramDto> findAll() {
        return mapper.mapAsList(programRepository.findAll(), ProgramDto.class);
    }

    @Override
    public void create(ProgramDto programDto) {
        programRepository.save(mapper.map(programDto, Program.class));
    }

    @Override
    public List<ProgramDto> findByType(String type) {

        return mapper.mapAsList(programRepository.findAllByType(InsuranceType.valueOf(type.toUpperCase())), ProgramDto.class);
    }

    @Override
    public ProgramDto findById(Long id) {
        return mapper.map(programRepository.getById(id), ProgramDto.class);
    }

    @Override
    public void update(ProgramDto programDto) {
        programRepository.save(mapper.map(programDto, Program.class));
    }

    @Override
    public void delete(Long id) {
        programRepository.deleteById(id);
    }
}
