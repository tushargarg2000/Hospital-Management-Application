package com.acciojob.Hospital.Management.System.Repository;


import com.acciojob.Hospital.Management.System.Models.Doctor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class DoctorRepository {

    Map<Integer,Doctor> doctorMap = new HashMap<>();

    public String addDoctorToDb(Doctor doctor){

        doctorMap.put(doctor.getDocId(),doctor);
        return "Doctor has been added to the DB with docId"+doctor.getDocId();
    }

    public List<Doctor> getAllDoctors(){
        log.info("We are in repo Layer returning all the doctors ");
        return doctorMap.values().stream().toList();
    }

}
