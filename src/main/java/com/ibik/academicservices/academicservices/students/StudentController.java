package com.ibik.academicservices.academicservices.students;

import org.springframework.web.bind.annotation.RestController;

import com.ibik.academicservices.academicservices.dto.ResponsData;

import java.util.List;

import java.util.ArrayList;

// import javax.management.RuntimeErrorException;
import javax.validation.Valid;

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

@RestController
@RequestMapping("/api/student")
public class StudentController {
    
    // @GetMapping
    // public String HelloWord () {
    //     return "<h1>Hello</h1>";
    // }
    @Autowired
    private StudentServices studentServices;

    @PostMapping()
    // public Student poststudents(@Valid @RequestBody Student students, Errors errors) {
    public ResponseEntity<ResponsData<Student>> postStudents (@Valid @RequestBody Student students, Errors errors) {
        
        ResponsData<Student> responseData = new ResponsData<>();

        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                // System.out.println(error.getDefaultMessage());
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setResult(false);
            responseData.setData(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
            // throw new RuntimeException("Validation Error");
        }

        responseData.setResult(true);
        List<Student> value = new ArrayList<>();
        value.add( studentServices.save(students) );
        responseData.setData(value);
        return ResponseEntity.ok(responseData);
        // return studentServices.save(students);
    }

    @GetMapping
    // public Iterable<Students> fetchStudent(){
        public ResponseEntity<ResponsData<Student>> fetchStudent() {

            ResponsData<Student> responseData = new ResponsData<>();

            try {
                Iterable<Student> values = studentServices.findAll();
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
            // return studentsServices.findAll();
        }
    
    @GetMapping("/{id}")
    // public Students fetchStudentById(@PathVariable("id") int id){
        public ResponseEntity<ResponsData<Student>> fetchStudentById(@PathVariable("id") int id) {
    
            ResponsData<Student> responseData = new ResponsData<>();
    
            try {
                Student values = studentServices.findOne(id);
                List<Student> result = new ArrayList<>();
                result.add(values);
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
            // return studentsServices.findOne(id);
        }


    @PutMapping
    // public Student updatestudents (@RequestBody Student students){
    public ResponseEntity<ResponsData<Student>> putStudents(@Valid @RequestBody Student students, Errors errors) {
        
        ResponsData<Student> responseData = new ResponsData<>();

        if (students.getId() != 0) {

            if (errors.hasErrors()) {
                for (ObjectError error : errors.getAllErrors()) {
                    responseData.getMessage().add(error.getDefaultMessage());
                }
                responseData.setResult(false);
                responseData.setData(null);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
            }

            responseData.setResult(true);
            List<Student> value = new ArrayList<>();
            value.add(studentServices.save(students));
            responseData.setData(value);
            return ResponseEntity.ok(responseData);

        } else {
            responseData.setResult(false);
            responseData.setData(null);
            List<String> message = new ArrayList<>();
            message.add("ID is required");
            responseData.setMessage(message);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @DeleteMapping("/{id}")
    //public void deleteStudentById(@PathVariable("id") int id){
    public ResponseEntity<ResponsData<Student>> deleteStudentById(@PathVariable("id") int id){    

        ResponsData<Student> responseData = new ResponsData<>();

        if(id != 0){
            try {
                studentServices.removeOne(id);
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

        } else {
            List<String> message = new ArrayList<>();
            message.add("ID is required");
            responseData.setMessage(message);
            responseData.setData(null);
            responseData.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

}