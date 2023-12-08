package shhkitt.rschir.kr.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shhkitt.rschir.kr.insurance.models.dto.ClientDtoAdmin;
import shhkitt.rschir.kr.insurance.controller.model.JwtResponse;
import shhkitt.rschir.kr.insurance.models.dto.ClientDto;
import shhkitt.rschir.kr.insurance.models.entity.Client;
import shhkitt.rschir.kr.insurance.auth.AuthService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody ClientDto clientDto) {
        return authService.login(clientDto);
    }

    @PostMapping("/reg")
    public String register(@RequestBody Client client) {
        return authService.register(client);
    }

    @GetMapping("/validate")
    public JwtResponse validateToken(@RequestParam String jwt) {
        return authService.validateToken(jwt);
    }

    @PatchMapping("/change-role")
    public String changeUserRoleToSeller(@RequestParam Long userId) {
        return authService.changeUserRoleToAdmin(userId);
    }

    @GetMapping("/users")
    public List<ClientDtoAdmin> getAllUsers() {
        List<Client> clients = authService.getAllUsers();
        return clients.stream()
                .map(client -> {
                    ClientDtoAdmin clientDTOAdmin = new ClientDtoAdmin();
                    clientDTOAdmin.setEmail(client.getEmail());
                    clientDTOAdmin.setRole(client.getRole());
                    return clientDTOAdmin;
                })
                .collect(Collectors.toList());
    }
    @GetMapping("/user")
    public Client getUserByEmail(@RequestParam Long id){
        return authService.getUserById(id);
    }
}