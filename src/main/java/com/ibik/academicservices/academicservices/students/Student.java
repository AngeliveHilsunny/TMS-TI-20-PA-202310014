package com.ibik.academicservices.academicservices.students;


import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ibik.academicservices.academicservices.courses.Courses;
import com.ibik.academicservices.academicservices.programs.Program;
import com.ibik.academicservices.academicservices.programstudy.Program_study;

// import org.springframework.web.bind.annotation.Mapping;

@Entity
@Table(name="students")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(value = 1, message = "Id is required") //MIN ITU INTEGER
    private int id;

    @Column(length = 15)
    @NotEmpty(message = "NPM is required") //NOT EMPTY ITU STRING
    private String npm;

    @Column(length = 10)
    @NotEmpty(message = "Firstname is required")
    private String firstname;

    @Column(length = 10)
    private String middlename;

    @Column(length = 10)
    @NotEmpty(message = "Lastname is required")
    private String lastname;

    @ManyToOne
    @JoinColumn(name = "program_id")
    private Program programs;

    @Column(length = 30)
    @NotEmpty(message = "Email is required")
    private String email;

    @ManyToOne
    @JoinColumn(name = "departement_id")
    private Program_study program_study;

    @JsonFormat(pattern="yyyy-MM-dd")
    @NotEmpty(message = "Brithdate is required")
    private Date birthdate;

    // Menampung 2 tabel dengan membuat tabel tampungan     
    @ManyToMany
    @JoinTable(
        name = "student_rel_courses",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Courses> courses;

    public Student() {
    }

    public Student
    (
        int id, 
        String npm, 
        String firstname, 
        String middlename, 
        String lastname,
        int program_id,
        int departement_id,
        Date birthdate,
        String email

    ) {
        this.id = id;
        this.npm = npm;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        // this.program_id = program_id;
        // this.departement_id = departement_id;
        this.birthdate = birthdate;
        this.email = email;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Courses> getCourses() {
        return courses;
    }

    public void setCourses(Set<Courses> courses) {
        this.courses = courses;
    }

    public Program getPrograms() {
        return programs;
    }

    public void setPrograms(Program programs) {
        this.programs = programs;
    }

    public Program_study getProgram_study() {
        return program_study;
    }

    public void setProgram_study(Program_study program_study) {
        this.program_study = program_study;
    }

    public Object findByEmail(String email2) {
        return null;
    }
}