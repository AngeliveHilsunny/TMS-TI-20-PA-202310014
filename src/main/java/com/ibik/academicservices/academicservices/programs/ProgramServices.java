package com.ibik.academicservices.academicservices.programs;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProgramServices{

  @Autowired
  private ProgramRepo programRepo;

  public Program save (Program programs) {
    return programRepo.save(programs);
    // save() = insert
  }

  public Program findOne (int id){
    return programRepo.findById(id).get ();
    // findById() = primarykey
  }

  public Iterable<Program> findAll(){
    return programRepo.findAll();
    // findAll() = select
  }

  public void removeOne(int id) {
    programRepo.deleteById(id);
    // deleteById() = delete condition berdasar primarykey
  }
}