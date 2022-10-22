package com.ibik.academicservices.academicservices.programstudy;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.ibik.academicservices.academicservices.dto.ResponsData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/program_study")
public class ProgramStudyController {
    
    @Autowired
    private ProgramStudyServices programStudyServices;

    @PostMapping
    public ResponseEntity<ResponsData<Program_study>> postProgramStudy(@Valid @RequestBody Program_study program_study, Errors errors) {
        // ResponseData<Students> responseData = new ResponseData<>();
        ResponsData<Program_study> responseData = new ResponsData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }

            responseData.setResult(false);
            responseData.setData(null);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        responseData.setResult(true);
        List<Program_study> value = new ArrayList<>();
        value.add(programStudyServices.save(program_study));
        responseData.setData(value);
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public ResponseEntity<ResponsData<Program_study>> fetchProgramStudy() {
        ResponsData<Program_study> responseData = new ResponsData<>();
        try {
            Iterable<Program_study> values = programStudyServices.findAll();
            responseData.setResult(true);
            responseData.setMessage(null);
            responseData.setData(values);
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            List<String> message = new ArrayList<>();
            message.add(e.getMessage());
            responseData.setMessage(message);
            responseData.setData(null);
            responseData.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsData<Program_study>> fetchProgramsById(@PathVariable("id") int id) {
        ResponsData<Program_study> responseData = new ResponsData<>();
        try {
            Program_study value = programStudyServices.findOne(id);
            List<Program_study> result = new ArrayList<>();
            result.add(value);
            responseData.setData(result);
            responseData.setResult(true);
            responseData.setMessage(null);
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            List<String> message = new ArrayList<>();
            message.add(e.getMessage());
            responseData.setMessage(message);
            responseData.setData(null);
            responseData.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @PutMapping
    public ResponseEntity<ResponsData<Program_study>> updatePrograms(@Valid @RequestBody Program_study program_study, Errors errors) {
        ResponsData<Program_study> responseData = new ResponsData<>();

        if (program_study.getId() != 0) {

            if (errors.hasErrors()) {
                for (ObjectError error : errors.getAllErrors()) {
                    responseData.getMessage().add(error.getDefaultMessage());
                }

                responseData.setResult(false);
                responseData.setData(null);

                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
            }

            responseData.setResult(true);
            List<Program_study> value = new ArrayList<>();
            value.add(programStudyServices.save(program_study));
            responseData.setData(value);
            return ResponseEntity.ok(responseData);
        } else {
            responseData.setResult(false);
            responseData.setData(null);
            List<Program_study> value = new ArrayList<>();
            value.add(programStudyServices.save(program_study));
            List<String> message = new ArrayList<>();
            message.add("ID is required");
            responseData.setMessage(message);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponsData<Program_study>> deleteProgramsById(@PathVariable("id") int id) {
        //programStudyServices.removeOne(id);
        ResponsData<Program_study> responseData = new ResponsData<>();
        if(id != 0){
            try {
                programStudyServices.removeOne(id);
                List<String> message = new ArrayList<>();
                message.add("Successfully removed");
                responseData.setMessage(message);
                responseData.setData(null);
                responseData.setResult(true);
                return ResponseEntity.ok(responseData);
            } catch (Exception e) {
                List<String> message = new ArrayList<>();
                message.add(e.getMessage());
                responseData.setMessage(message);
                responseData.setData(null);
                responseData.setResult(false);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
            }
        }else{
            List<String> message = new ArrayList<>();
            message.add("ID is required");
            responseData.setMessage(message);
            responseData.setData(null);
            responseData.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

}