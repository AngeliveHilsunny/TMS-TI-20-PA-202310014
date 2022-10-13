package com.ibik.academicservices.academicservices.programs;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Student postProgram(@RequestBody Student program) {
        return studentServices.save(program);
    }

    @GetMapping
    public Iterable<Student> fetchPrograms(){
        return studentServices.findAll();
    }

    @GetMapping("/{id}")
    public Student fetchProgramsById(@PathVariable("id") int id){
        return studentServices.findOne(id);
    }

    @PutMapping
    public Student updatePrograms (@RequestBody Student programs){
        return studentServices.save(programs);
    }

    @DeleteMapping("/{id}")
    public void deleteProgramsById(@PathVariable("id") int id ) {
        studentServices.removeOne(id) ;
    }

}