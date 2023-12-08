package shhkitt.rschir.kr.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shhkitt.rschir.kr.insurance.models.InsuranceType;
import shhkitt.rschir.kr.insurance.models.entity.Program;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Long> {
    List<Program> findAllByType(InsuranceType type);

    Program getById(Long id);
}
