package shhkitt.rschir.kr.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shhkitt.rschir.kr.insurance.models.entity.Contract;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
    Contract getById(Long id);
    List<Contract> findAllByInsuredId(Long id);
}
