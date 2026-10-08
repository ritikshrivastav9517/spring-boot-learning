
package com.codeshuttle.week1.demo.services;

import com.codeshuttle.week1.demo.Entities.EmployeeEntity;
import com.codeshuttle.week1.demo.dto.EmployeeDTO;
import com.codeshuttle.week1.demo.repostitories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;

import java.util.stream.Collectors;
@Service

public class EmployeeService {

    public List<EmployeeEntity> findByName(String name) {
        return employeeRepository.findByName(name);
    }

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }


    public Optional<EmployeeDTO> getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .map(employeeEntity ->
                        modelMapper.map(employeeEntity, EmployeeDTO.class));
    }


//    public EmployeeDTO getEmployeeById(Long id) {
//        EmployeeEntity employeeEntity =
//                employeeRepository.findById(id).orElse(null);
//
//        return modelMapper.map(employeeEntity, EmployeeDTO.class);
//    }

    //GetMapping of whole data
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();

        return employeeEntities
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }



    //post
    public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee) {
        EmployeeEntity toSaveEntity =
                modelMapper.map(inputEmployee, EmployeeEntity.class);

        EmployeeEntity savedEmployeeEntity =
                employeeRepository.save(toSaveEntity);

        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

    //Put Mapping
//    public EmployeeDTO updateEmployee(Long id, EmployeeDTO inputEmployee) {
//
//        EmployeeEntity existingEmployee = employeeRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Employee not found"));
//
//        existingEmployee.setName(inputEmployee.getName());
//        existingEmployee.setEmail(inputEmployee.getEmail());
//        existingEmployee.setAge(inputEmployee.getAge());
//        existingEmployee.setDateOfJoining(inputEmployee.getDateOfJoining());
//        existingEmployee.setIsActive(inputEmployee.getActive());
//
//        EmployeeEntity updatedEmployee =
//                employeeRepository.save(existingEmployee);
//
//        return modelMapper.map(updatedEmployee, EmployeeDTO.class);
//    }



}