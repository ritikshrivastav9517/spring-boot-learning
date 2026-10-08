package com.codeshuttle.week1.demo.controllers;

import com.codeshuttle.week1.demo.Entities.EmployeeEntity;
import com.codeshuttle.week1.demo.dto.EmployeeDTO;
import com.codeshuttle.week1.demo.repostitories.EmployeeRepository;
import com.codeshuttle.week1.demo.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import java.util.NoSuchElementException;



import java.time.LocalDate;
import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //JPA Query
    @GetMapping("/employees/search")
    public List<EmployeeEntity> findByName(@RequestParam String name) {
        return employeeService.findByName(name);
    }




    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeByID(
            @PathVariable Long employeeId) {

        Optional<EmployeeDTO> employeeDTOOptional =
                employeeService.getEmployeeById(employeeId);

        return employeeDTOOptional
                .map(ResponseEntity::ok)
                .orElseThrow(() ->
                        new NoSuchElementException(
                                "Employee not found with id: " + employeeId));
    }


    @GetMapping(path = "/employees")
    public List<EmployeeDTO> getAllEmployees(
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) String sortBy) {

        return employeeService.getAllEmployees();
    }


    @PostMapping("/employees")
    public EmployeeDTO createNewEmployee(
            @RequestBody @Valid EmployeeDTO inputEmployee) {

        return employeeService.createNewEmployee(inputEmployee);
    }



}

