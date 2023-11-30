package com.acciojob.Hospital.Management.System.Controllers;

import com.acciojob.Hospital.Management.System.Models.Patient;
import com.acciojob.Hospital.Management.System.Services.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/add")
    public String addPatient(@RequestBody Patient patient) {
        return null;
        //Do something
    }

    @GetMapping("/getInfo")
    public Patient getPatientInfo(@RequestParam("patientId")Integer patientId){
        return null;

    }

    @GetMapping("validateAge")
    public String validateAgeForDose(@RequestParam("age")Integer age){

        try {
            String result = patientService.validateAge(age);
            return result;
        }catch (Exception e){
            log.error("Age entered was incorrect");
            return e.getMessage();
        }



    }
}
