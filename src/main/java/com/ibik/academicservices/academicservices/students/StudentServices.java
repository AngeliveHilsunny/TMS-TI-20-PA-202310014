package com.ibik.academicservices.academicservices.students;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StudentServices{

  @Autowired
  private StudentRepo studentRepo;

  public Student save (Student students) {
    return studentRepo.save(students);
    // save() = insert
  }

  public Student findOne (int id){
    return studentRepo.findById(id).get ();
    // findById() = primarykey
  }

  public Iterable<Student> findAll(){
    return studentRepo.findAll();
    // findAll() = select
  }

  public void removeOne(int id) {
    studentRepo.deleteById(id);
    // deleteById() = delete condition berdasar primarykey
  }
}