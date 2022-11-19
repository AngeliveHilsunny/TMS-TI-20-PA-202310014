package com.ibik.academicservices.academicservices.programstudy;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.ibik.academicservices.academicservices.programs.Program;

@Entity
@Table(name="program_study")
public class Program_study implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  @Column(length = 50)
  @NotEmpty(message = "Name is required")
  private String name;

  private String description;

  @Column(length = 10, unique = true)
  @NotEmpty(message = "Code is required")
  private String code;
  // MANY TO ONE
  // SEBELUM
  // @NotEmpty(message = "program_id is required")
  // private int program_id;

  // SESUDAH
  @ManyToOne
  @JoinColumn(name = "program_id")
  private Program programs;

  // ONE TO MANY
  // SEBELUM
  // @NotEmpty(message = "faculty_id is required")
  // private int faculty_id;
  @OneToMany
  @JoinColumn(name = "faculty_id")
  private Set<Program_study> Departments;

  private int departement_id;

  @Column(columnDefinition = "TINYINT(1)")
    private boolean is_active;

  public Program_study() {
  }

  public Program_study(
    int id, 
    String name, 
    String description, 
    String code,
    // int faculty_id, (DIHAPUS DAN DIGANTI)
    int departement_id,
    boolean is_active
    ) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.code = code;
    this.is_active = is_active;
    // this.faculty_id = faculty_id;  (DIHAPUS DAN DIGANTI)
    this.departement_id = departement_id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Program getPrograms() {
    return programs;
  }

  public void setPrograms(Program programs) {
    this.programs = programs;
  }

  public Set<Program_study> getDepartments() {
    return Departments;
  }

  public void setDepartments(Set<Program_study> departments) {
    Departments = departments;
  }

  public int getDepartement_id() {
    return departement_id;
  }

  public void setDepartement_id(int departement_id) {
    this.departement_id = departement_id;
  }

  public boolean isIs_active() {
    return is_active;
  }

  public void setIs_active(boolean is_active) {
    this.is_active = is_active;
  }

  

}