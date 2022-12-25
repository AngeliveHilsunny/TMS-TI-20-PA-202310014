package com.ibik.academicservices.academicservices.courses;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class CoursesServices {
    @Autowired
    private CoursesRepo coursesRepo;

    //insert
    public Courses save(Courses courses){
        //DTO
        return coursesRepo.save(courses);
    }

    public Courses findOne(int id){
        return coursesRepo.findById(id).get();
    }

    public Iterable<Courses> findAll(){
        return coursesRepo.findAll();
    }

    public void removeOne(int id){
        coursesRepo.deleteById(id);
    }

    public Courses update(Courses courses) {
        Courses result = findOne(courses.getId());

        result.setCode(courses.getCode());
        result.setCredit(courses.getCredit());
        result.setIs_active(courses.isIs_active());
        result.setName(courses.getName());

        return result;
    }
}