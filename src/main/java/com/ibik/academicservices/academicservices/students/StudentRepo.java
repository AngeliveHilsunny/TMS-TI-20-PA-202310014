package com.ibik.academicservices.academicservices.students;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface StudentRepo extends CrudRepository <Student, Integer> {
    // JPQL
    // @Query("SELECT a FROM Student a WHERE a.firstname = :name")
    // public Iterable<Student> findStudentByName(@PathParam("name") String name);

    // JPL
    // @Query("SELECT a.* FROM Students a WHERE a.firstname = :name", nativeQuery = true)
    // public Iterable<Student> findStudentByName (@PathParam("name") String name);

    // QUIZ 1.
    @Query("SELECT a FROM Student a WHERE a.firstname LIKE :name OR a.middlename LIKE :name OR a.lastname LIKE :name OR a.npm LIKE :name")
    public Iterable<Student> findStudentByName(@PathParam("name") String name);

    @Query(value = "SELECT a.* FROM students a WHERE a.email = :email AND concat(DATE_FORMAT(a.birth_date, '%d%m%Y'), '@', a.npm) = :password", nativeQuery = true)
    public Iterable<Student> findStudentAuth(@Param("email") String email, @Param("password") String password);
}
