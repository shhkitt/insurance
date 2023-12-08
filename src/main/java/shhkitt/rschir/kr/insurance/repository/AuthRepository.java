package shhkitt.rschir.kr.insurance.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shhkitt.rschir.kr.insurance.models.entity.Client;

@Repository
public interface AuthRepository extends JpaRepository<Client, Long> {
    Client getClientByEmailAndPassword(String email, String password);
    Client findByEmail(String email);
}