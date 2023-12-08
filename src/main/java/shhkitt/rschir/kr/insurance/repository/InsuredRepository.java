package shhkitt.rschir.kr.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shhkitt.rschir.kr.insurance.models.entity.Insured;

import java.util.List;

@Repository
public interface InsuredRepository extends JpaRepository<Insured, Long> {
    Insured getById(Long id);
    List<Insured> findAllByClientId(Long id);
}
