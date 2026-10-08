package com.codeshuttle.week1.demo;

import com.codeshuttle.week1.demo.Entities.EmployeeEntity;
import com.codeshuttle.week1.demo.repostitories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class EmployeeTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void testFindAllEmployees() {

        //List<EmployeeEntity> employeeList = employeeRepository.findAll();

        Page<Patient> patientList = patientRepository.findAllPatients(PageRequest.of(1, 2, Sort.by("name")));

        for(Patient patient: patientList) {
            System.out.println(patient);
        }


        List<EmployeeEntity> employeeList = employeeRepository.findByName("Ritik");

        patientRepository.findByName("Divya Patel");

        patientRepository.findByBirthDateOrEmail(
                LocalDate.of(1988, 3, 15),
                "divya.patel@example.com"
        );

        patientRepository.findByBornAfterDate(
                LocalDate.of(1993, 3, 14)
        );

        patientRepository.findAllPatients();

        patientRepository.countEachBloodGroupType();

        patientRepository.updateNameWithId("Aray Sharma", 1L);




        employeeList.forEach(System.out::println);
    }
}