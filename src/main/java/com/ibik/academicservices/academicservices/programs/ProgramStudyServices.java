package com.ibik.academicservices.academicservices.programs;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProgramStudyServices{

  @Autowired
  private ProgramStudyRepo programStudyRepo;

  public Program_study save (Program_study programs) {
    return programStudyRepo.save(programs);
    // save() = insert
  }

  public Program_study findOne (int id){
    return programStudyRepo.findById(id).get ();
    // findById() = primarykey
  }

  public Iterable<Program_study> findAll(){
    return programStudyRepo.findAll();
    // findAll() = select
  }

  public void removeOne(int id) {
    programStudyRepo.deleteById(id);
    // deleteById() = delete condition berdasar primarykey
  }
}