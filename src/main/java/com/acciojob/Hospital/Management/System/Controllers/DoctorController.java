package com.acciojob.Hospital.Management.System.Controllers;

import com.acciojob.Hospital.Management.System.Models.Doctor;
import com.acciojob.Hospital.Management.System.Services.DoctorServiceLayer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController //This denotes API endpoints are written here.
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    private DoctorServiceLayer doctorServiceLayerObj;


    @GetMapping("/getLogs")
    public void getLogs(){

        log.error("This is an error message");
        log.warn("This is a warning message");
        log.info("This is an information");
        log.debug("This is debug message");
        log.trace("This is a trace message");
    }



    @PostMapping("/add")
    public ResponseEntity addDoctor(@RequestBody Doctor doctor) {

        log.info("We have got the request doctor {}",doctor);
        String result = doctorServiceLayerObj.addDoctor(doctor);

        return new ResponseEntity(result, HttpStatus.CREATED);

    }

    @GetMapping("/getDoc")
    public ResponseEntity getDocNameWithMaxExp(){

        log.info("We are in the getDoc Name With Max Experience ");
        String name = doctorServiceLayerObj.getDocNameWithMaxExp();

        if(name==""){
            return new ResponseEntity(name,HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity(name,HttpStatus.OK);
    }

    @GetMapping("/getDocListWithDegree")
    public List<Doctor> getDocListWithDegree(@RequestParam("degree")String degree){

        List<Doctor> doctors = doctorServiceLayerObj.getListOfDoctor(degree);
        return doctors;
    }



}
