package com.beehyv.server.repository;

import com.beehyv.server.entity.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO employee_tasks(employee_id, tasks_id) " +
            "VALUES(:employeeId, :taskId)",
            nativeQuery = true)
    void mapTaskIdWithEmployeeId(Long taskId, Long employeeId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO project_tasks(project_id, tasks_id) " +
            "VALUES(:projectId, :taskId)",
            nativeQuery = true)
    void mapTaskIdWithProjectId(Long taskId, Long projectId);

}
