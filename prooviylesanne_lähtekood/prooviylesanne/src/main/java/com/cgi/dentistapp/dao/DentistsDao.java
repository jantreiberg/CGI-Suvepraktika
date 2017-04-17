package com.cgi.dentistapp.dao;

import com.cgi.dentistapp.dao.entity.DentistEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

/**
 * Created by jantr_000 on 16.04.2017.
 */
public class DentistsDao { @PersistenceContext
private EntityManager entityManager;

    public void create(DentistEntity dentist){
        entityManager.persist(dentist);
    }

    public List<DentistEntity> getAllDentists(){
        return entityManager.createQuery("select e from DentistsEntity e").getResultList();
    }



}
