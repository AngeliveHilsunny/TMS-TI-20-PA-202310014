package com.ibik.academicservices.academicservices.programs;

import org.springframework.data.repository.CrudRepository;

public interface ProgramRepo extends CrudRepository <Program, Integer> {
    
}
//Interface node ini akan menjadi penghubung antara scripting dengan database. 
//Disini dapat berisifunction-function yang berisi Query SQL.