package com.acciojob.Hospital.Management.System;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //This will tell spring that this is service layer and logic is written here
public class ServiceLayer {

    @Autowired
    private RepositoryLayer repoObj;

    public String addDoctor(Doctor doctor){

        //This is where some data processing is done
        String result = repoObj.addDoctorToDb(doctor);
        return result;
    }

    public String getDocNameWithMaxExp(){
        //From repo you got the raw data
        List<Doctor> doctorList = repoObj.getAllDoctors();

        //Process on the raw from DB
        int exp = 0;
        String docName = "";
        for(Doctor doctor:doctorList){

            if(doctor.getExperience()==exp) {
                if(doctor.getName().compareTo(docName)<0){
                    docName = doctor.getName();
                }
            }
            if(doctor.getExperience()>exp){
                exp = doctor.getExperience();
                docName = doctor.getName();
            }
        }
        return docName;
    }

    public List<Doctor> getListOfDoctor(String degree) {

        List<Doctor> doctorList = repoObj.getAllDoctors();
        List<Doctor> finalAnsList = new ArrayList<>();

        for(Doctor doctor:doctorList) {
            if(doctor.getDegree().equals(degree)){
                finalAnsList.add(doctor);
            }
        }
        return finalAnsList;
    }

}
