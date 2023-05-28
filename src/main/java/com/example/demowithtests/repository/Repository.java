package com.example.demowithtests.repository;

import com.example.demowithtests.domain.Employee;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Employee, Integer> {

    @Query(value = "select * from users where is_deleted=false", nativeQuery = true)
    List<Employee> findAll();

    @Query(value = "select * from users where id=? and is_deleted=false", nativeQuery = true)
    Optional<Employee> findById(Integer id);

    @Query(value = "select * from users where name=? and is_deleted=false", nativeQuery = true)
    Employee findByName(String name);
}
