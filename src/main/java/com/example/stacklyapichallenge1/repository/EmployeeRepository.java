package com.example.stacklyapichallenge1.repository;

import com.example.stacklyapichallenge1.entities.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    Employee findByEmail(String email);
    @Modifying
    @Query(value = "insert into employee_skill (employee_id, skill_id) values (:employeeId, :skillId)", nativeQuery = true)
    void AddSkillToUser(@Param(value = "employeeId") int employeeId , @Param(value = "skillId") int skillId);

}
