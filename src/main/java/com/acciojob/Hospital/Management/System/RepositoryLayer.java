package com.acciojob.Hospital.Management.System;


import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RepositoryLayer {

    Map<Integer,Doctor> doctorMap = new HashMap<>();

    public String addDoctorToDb(Doctor doctor){

        doctorMap.put(doctor.getDocId(),doctor);
        return "Doctor has been added to the DB with docId"+doctor.getDocId();
    }

    public List<Doctor> getAllDoctors(){
        return doctorMap.values().stream().toList();
    }

}
