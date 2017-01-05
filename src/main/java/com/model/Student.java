package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.sql.Date;

/**
 * Created by Main Server on 04.01.2017.
 */
@Entity
@Table(name = "student", schema = "public")
public class Student {
    private int id;
    private String surname;
    private String name;
    private Date dateOfBirth;
    private String state;
    private String campus;
    private Date dateOfJoin;

    public Student() {
    }

    public Student(int id, String surname, String name, Date dateOfBirth, String state, String campus, Date dateOfJoin) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.state = state;
        this.campus = campus;
        this.dateOfJoin = dateOfJoin;
    }

    public Student(String surname, String name, Date dateOfBirth, String state, String campus, Date dateOfJoin) {
        this.surname = surname;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.state = state;
        this.campus = campus;
        this.dateOfJoin = dateOfJoin;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @SequenceGenerator(name = "student_seq", sequenceName = "student_id_seq", allocationSize = 1)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "date_of_birth")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name = "campus")
    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    @Column(name = "date_of_join")
    public Date getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(Date dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (surname != null ? !surname.equals(student.surname) : student.surname != null) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(student.dateOfBirth) : student.dateOfBirth != null) return false;
        if (state != null ? !state.equals(student.state) : student.state != null) return false;
        if (campus != null ? !campus.equals(student.campus) : student.campus != null) return false;
        if (dateOfJoin != null ? !dateOfJoin.equals(student.dateOfJoin) : student.dateOfJoin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (campus != null ? campus.hashCode() : 0);
        result = 31 * result + (dateOfJoin != null ? dateOfJoin.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student : " +
                "id : " + id +
                ", Family name : " + surname + '\'' +
                ", First Name : " + name + '\'' +
                ", Date of Birth : " + dateOfBirth +
                ", State : " + state + '\'' +
                ", Campus : " + campus + '\'' +
                ", Date of Join : " + dateOfJoin + "\n";
    }
}
