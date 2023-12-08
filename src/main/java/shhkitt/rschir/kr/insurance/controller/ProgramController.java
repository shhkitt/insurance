package shhkitt.rschir.kr.insurance.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shhkitt.rschir.kr.insurance.controller.model.CommonResponse;
import shhkitt.rschir.kr.insurance.models.dto.ProgramDto;
import shhkitt.rschir.kr.insurance.service.ProgramService;

import java.util.List;

@RestController
@RequestMapping("/insurance")
@RequiredArgsConstructor
public class ProgramController {

    private final ProgramService programService;

    //получение всех программ страхования
    @GetMapping("/all")
    public ResponseEntity<List<ProgramDto>> getAllPrograms(){
        try {
            List<ProgramDto> programs = programService.findAll();
            return ResponseEntity.ok(programs);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<ProgramDto>> getByType(@PathVariable("type") String type){
        try {
            return ResponseEntity.ok(programService.findByType(type));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ProgramDto> getById(@PathVariable("id") String id){
        try {
            return ResponseEntity.ok(programService.findById(Long.valueOf(id)));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }




    //добавление новой программы страховки (адм)
    @PostMapping("/add")
    public ResponseEntity<CommonResponse> createProgram(@RequestBody ProgramDto program){
        try {
            programService.create(program);
            return ResponseEntity.ok(new CommonResponse("0"));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }


    @PutMapping("/update")
    public ResponseEntity<CommonResponse> updateProgram(@RequestBody ProgramDto program){
        try{
            programService.update(program);
            return ResponseEntity.ok(new CommonResponse("0"));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CommonResponse> deleteProgram(@PathVariable("id") String id){
        try{
            programService.delete(Long.valueOf(id));
            return ResponseEntity.ok(new CommonResponse("0"));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

}
