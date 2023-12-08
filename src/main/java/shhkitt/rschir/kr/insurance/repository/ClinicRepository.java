package shhkitt.rschir.kr.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shhkitt.rschir.kr.insurance.models.entity.Clinic;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic, Long> {
    Clinic getById(Long id);
}
