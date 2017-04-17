package com.cgi.dentistapp.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "dentist_visit")
public class DentistVisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //Visitation time
    @Column(name = "visit_time")
    public Date visitTime;

    //Doctors name
    @Column(name = "dentist_name")
    public String dentistName;

    public DentistVisitEntity() {
    }

    public DentistVisitEntity(String dentistName, Date visitTime) {

        this.setVisitTime(visitTime);
        this.setDentistName(dentistName);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    private void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getDentistname(){
        return dentistName;
    }

    private void setDentistName(String dentistName) {
        this.dentistName = dentistName;
    }

}
