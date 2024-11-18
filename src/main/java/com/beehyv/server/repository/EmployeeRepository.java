package com.beehyv.server.repository;

import com.beehyv.server.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "SELECT t.* FROM task t " +
            "JOIN employee_tasks et ON t.id = et.tasks_id " +
            "WHERE et.employee_id = :employeeId",
            nativeQuery = true)
    List<Long> findEmployeesTaskIds(Long employeeId);

    @Query(value = "SELECT p.* FROM project p " +
            "JOIN employee_projects ep ON p.id = ep.projects_id " +
            "WHERE ep.employee_id = :employeeId",
            nativeQuery = true)
    List<Long> findEmployeesProjectIds(Long employeeId);
}
