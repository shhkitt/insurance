package shhkitt.rschir.kr.insurance.auth;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import shhkitt.rschir.kr.insurance.controller.model.JwtResponse;
import shhkitt.rschir.kr.insurance.models.dto.ClientDto;
import shhkitt.rschir.kr.insurance.models.entity.Client;
import shhkitt.rschir.kr.insurance.repository.AuthRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final JwtProvider jwtProvider;
    private final AuthRepository authRepository;


    public ResponseEntity<String> login(ClientDto clientDto) {
        Client client = authRepository.getClientByEmailAndPassword(clientDto.getEmail(), clientDto.getPassword());
        if(client != null) {
            return new ResponseEntity<>(jwtProvider.generateToken(client), HttpStatus.valueOf(200));
        }
        return new ResponseEntity<>(HttpStatus.valueOf(400));

    }

    public String register(Client client) {
        if (authRepository.findByEmail(client.getEmail()) != null){
            return "USER WITH THIS LOGIN ALREADY EXISTS";
        }
        authRepository.save(client);
        return "SUCCESS";
    }

    public JwtResponse validateToken(String jwt) {
        Claims claims = jwtProvider.validateToken(jwt);
        JwtResponse jwtResponse = new JwtResponse();
        jwtResponse.id = claims.get("id", Integer.class);
        jwtResponse.role = claims.get("role", String.class);
        jwtResponse.email = claims.get("email", String.class);
        return jwtResponse;
    }

    public String changeUserRoleToAdmin(Long userId) {
        Client client = authRepository.findById(userId).orElse(null);
        if (client != null) {
            client.role = "ADMIN";
            authRepository.saveAndFlush(client);
            return "SUCCESS";
        }
        return "NO SUCH USER";
    }

    public List<Client> getAllUsers(){
        return authRepository.findAll();
    }

    public Client getClientByEmail(String email){
        return authRepository.findByEmail(email);
    }
    public Client getUserById(Long id){
        return authRepository.findById(id).orElse(null);
    }
}
