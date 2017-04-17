
package com.cgi.dentistapp.dao.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "dentists")
public class DentistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //Visitation time
    @Column(name = "visit_time")
    public Date visitTime;

    //Doctors name
    @Column(name = "dentist_name")
    public String dentistName;
    public DentistEntity(String dentistName, Date visitTime) {

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

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getDentistname(){
        return dentistName;
    }

    public void setDentistName(String dentistName) {
        this.dentistName = dentistName;
    }

}