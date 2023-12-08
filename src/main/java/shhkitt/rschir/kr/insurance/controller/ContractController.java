package shhkitt.rschir.kr.insurance.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shhkitt.rschir.kr.insurance.controller.model.CommonResponse;
import shhkitt.rschir.kr.insurance.models.dto.ContractDto;
import shhkitt.rschir.kr.insurance.service.ContractService;

import java.util.List;
@RestController
@RequestMapping("/contract")
@RequiredArgsConstructor
public class ContractController {

    private final ContractService contractService;
    @GetMapping("/all")
    public ResponseEntity<List<ContractDto>> getAllContracts(){
        try {
            List<ContractDto> contracts = contractService.findAll();
            return ResponseEntity.ok(contracts);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @GetMapping("/insurer/{id}")
    public ResponseEntity<List<ContractDto>> getByInsurer(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(contractService.findByInsured(id));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ContractDto> getById(@PathVariable("id") String id){
        try {
            return ResponseEntity.ok(contractService.findById(Long.valueOf(id)));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<CommonResponse> createContract(@RequestBody ContractDto contract){
        try {
            contractService.create(contract);
            return ResponseEntity.ok(new CommonResponse("0"));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<CommonResponse> updateContract(@RequestBody ContractDto contract){
        try{
            contractService.update(contract);
            return ResponseEntity.ok(new CommonResponse("0"));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CommonResponse> deleteContract(@PathVariable("id") String id){
        try{
            contractService.delete(Long.valueOf(id));
            return ResponseEntity.ok(new CommonResponse("0"));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
