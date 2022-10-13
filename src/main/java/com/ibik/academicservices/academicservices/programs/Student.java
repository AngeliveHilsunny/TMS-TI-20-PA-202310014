package com.ibik.academicservices.academicservices.programs;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 15)
    private String npm;

    @Column(length = 10)
    private String firstname;

    @Column(length = 10)
    private String middlename;

    @Column(length = 10)
    private String lastname;

    @Column(columnDefinition = "INT(11)")
    private int program_id;

    @Column(columnDefinition = "INT(11)")
    private int departement_id;

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
        int departement_id
    ) {
        this.id = id;
        this.npm = npm;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.program_id = program_id;
        this.departement_id = departement_id;
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

    public int getprogram_id() {
        return program_id;
    }

    public int getdepartment_id() {
        return departement_id;
    }

}