package com.codeshuttle.week1.demo.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 10, message = "Name must be 3 to 10 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Enter a valid email")
    private String email;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 80, message = "Age must not exceed 80")
    private Integer age;

    @NotBlank(message = "Role is required")
    @Pattern(regexp = "USER|ADMIN",
            message = "Role must be USER or ADMIN")
    private String role;

    @NotNull(message = "Salary is required")
    @Positive(message = "Salary must be positive")
    @Digits(integer = 6, fraction = 2,
            message = "Salary can have up to 6 integer and 2 decimal digits")
    @DecimalMin(value = "100.50", message = "Minimum salary is 100.50")
    @DecimalMax(value = "100000.99", message = "Maximum salary is 100000.99")
    private Double salary;

    @PastOrPresent(message = "Joining date cannot be in the future")
    private LocalDate dateOfJoining;

    @NotNull(message = "isActive is required")
    @AssertTrue(message = "Employee must be active")
    @JsonProperty("isActive")
    private Boolean isActive;

    public EmployeeDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}