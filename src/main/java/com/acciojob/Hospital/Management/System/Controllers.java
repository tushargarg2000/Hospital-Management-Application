package com.acciojob.Hospital.Management.System;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.print.Doc;
import java.util.List;

@RestController //This denotes API endpoints are written here.
public class Controllers {

    @Autowired
    private ServiceLayer serviceLayerObj;

    @PostMapping("/addDoctor")
    public String addDoctor(@RequestBody Doctor doctor){

        String result = serviceLayerObj.addDoctor(doctor);
        return result;
    }

    @GetMapping("/getDoc")
    public String getDocNameWithMaxExp(){

        String name = serviceLayerObj.getDocNameWithMaxExp();
        return name;
    }

    @GetMapping("/getDocListWithDegree")
    public List<Doctor> getDocListWithDegree(@RequestParam("degree")String degree){

        List<Doctor> doctors = serviceLayerObj.getListOfDoctor(degree);
        return doctors;
    }



}
