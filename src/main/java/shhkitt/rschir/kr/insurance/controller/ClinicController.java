package shhkitt.rschir.kr.insurance.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shhkitt.rschir.kr.insurance.controller.model.CommonResponse;
import shhkitt.rschir.kr.insurance.models.dto.ClinicDto;
import shhkitt.rschir.kr.insurance.service.ClinicService;

import java.util.List;

@RestController
@RequestMapping("/insurance/clinic")
@RequiredArgsConstructor
public class ClinicController {

    private final ClinicService clinicService;

    @GetMapping("/all")
    public ResponseEntity<List<ClinicDto>> getAllClinics(){
        try {
            List<ClinicDto> clinics = clinicService.findAll();
            return ResponseEntity.ok(clinics);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ClinicDto> getById(@PathVariable("id") String id){
        try {
            return ResponseEntity.ok(clinicService.findById(Long.valueOf(id)));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<CommonResponse> createClinic(@RequestBody ClinicDto clinicDto){
        try {
            clinicService.create(clinicDto);
            return ResponseEntity.ok(new CommonResponse("0"));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<CommonResponse> updateClinic(@RequestBody ClinicDto clinicDto){
        try{
            clinicService.update(clinicDto);
            return ResponseEntity.ok(new CommonResponse("0"));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CommonResponse> deleteClinic(@PathVariable("id") String id){
        try{
            clinicService.delete(Long.valueOf(id));
            return ResponseEntity.ok(new CommonResponse("0"));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
