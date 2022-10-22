package com.ibik.academicservices.academicservices.students;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository <Student, Integer> {
    
}
