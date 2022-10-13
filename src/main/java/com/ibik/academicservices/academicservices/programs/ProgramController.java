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
@RequestMapping("/api/programs")
public class ProgramController {
    
    // @GetMapping
    // public String HelloWord () {
    //     return "<h1>Hello</h1>";
    // }
    @Autowired
    private ProgramServices programServices;

    @PostMapping()
    public Program postProgram(@RequestBody Program program) {
        return programServices.save(program);
    }

    @GetMapping
    public Iterable<Program> fetchPrograms(){
        return programServices.findAll();
    }

    @GetMapping("/{id}")
    public Program fetchProgramsById(@PathVariable("id") int id){
        return programServices.findOne(id);
    }

    @PutMapping
    public Program updatePrograms (@RequestBody Program programs){
        return programServices. save (programs);
    }

    @DeleteMapping("/{id}")
    public void deleteProgramsById(@PathVariable("id") int id ) {
    programServices. removeOne(id) ;
    }

}