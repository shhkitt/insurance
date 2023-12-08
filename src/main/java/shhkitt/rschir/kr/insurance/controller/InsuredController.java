package shhkitt.rschir.kr.insurance.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shhkitt.rschir.kr.insurance.controller.model.CommonResponse;
import shhkitt.rschir.kr.insurance.models.dto.InsuredDto;
import shhkitt.rschir.kr.insurance.service.InsuredService;

import java.util.List;

@RestController
@RequestMapping("/insured")
@RequiredArgsConstructor
public class InsuredController {

    private final InsuredService insuredService;

    @GetMapping("/all")
    public ResponseEntity<List<InsuredDto>> getAllInsureds(){
        try {
            List<InsuredDto> insureds = insuredService.findAll();
            return ResponseEntity.ok(insureds);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<InsuredDto> getById(@PathVariable("id") String id){
        try {
            return ResponseEntity.ok(insuredService.findById(Long.valueOf(id)));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<CommonResponse> createInsured(@RequestBody InsuredDto insuredDto){
        try {
            insuredService.create(insuredDto);
            return ResponseEntity.ok(new CommonResponse("0"));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<CommonResponse> updateInsured(@RequestBody InsuredDto insuredDto){
        try{
            insuredService.update(insuredDto);
            return ResponseEntity.ok(new CommonResponse("0"));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CommonResponse> deleteInsured(@PathVariable("id") String id){
        try{
            insuredService.delete(Long.valueOf(id));
            return ResponseEntity.ok(new CommonResponse("0"));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

}
