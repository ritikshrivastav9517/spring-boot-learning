package com.codeshuttle.week1.demo.repostitories;

import com.codeshuttle.week1.demo.Entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
//import java.util.Optional;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

      List<EmployeeEntity> findByName(String name);
    //Optional<EmployeeEntity> findByName(String name);

    @Query("SELECT p FROM Patient p where p.bloodGroup = ?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup)



    // JPQL Query
    @Query("select p from Patient p where p.birthDate > :birthDate")
    List<Patient> findByBornAfterDate(
            @Param("birthDate") LocalDate birthDate
    );

    // Native Query
    @Query(value = "select * from patient", nativeQuery = true)
    List<Patient> findAllPatients();

    // Group By Query
    @Query("select p.bloodGroup, Count(p) from Patient p group by p.bloodGroup")
    List<Object[]> countEachBloodGroupType();



    //Pagetation
    @Query(value = "select * from patient", nativeQuery = true)
    Page<Patient> findAllPatients(Pageable pageable);



    // Update Query
    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.name = :name where p.id = :id")
    int updateNameWithId(
            @Param("name") String name,
            @Param("id") Long id
    );


    //Projection getting selected field
    @Query("select new com.codingshuttle.youtube.hospitalManagement.dto.BloodGroupCountResponseEntity(p.bloodGroup," +
            " Count(p)) from Patient p group by p.bloodGroup")
//    List<Object[]> countEachBloodGroupType();
    List<BloodGroupCountResponseEntity> countEachBloodGroupType();



}
