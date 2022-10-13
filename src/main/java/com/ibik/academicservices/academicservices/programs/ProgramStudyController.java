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
@RequestMapping("/api/program_study")
public class ProgramStudyController {
    
    // @GetMapping
    // public String HelloWord () {
    //     return "<h1>Hello</h1>";
    // }
    @Autowired
    private ProgramStudyServices programStudyServices;

    @PostMapping()
    public Program_study postProgram(@RequestBody Program_study program) {
        return programStudyServices.save(program);
    }

    @GetMapping
    public Iterable<Program_study> fetchPrograms(){
        return programStudyServices.findAll();
    }

    @GetMapping("/{id}")
    public Program_study fetchProgramsById(@PathVariable("id") int id){
        return programStudyServices.findOne(id);
    }

    @PutMapping
    public Program_study updatePrograms (@RequestBody Program_study programs){
        return programStudyServices. save (programs);
    }

    @DeleteMapping("/{id}")
    public void deleteProgramsById(@PathVariable("id") int id ) {
        programStudyServices. removeOne(id) ;
    }

}