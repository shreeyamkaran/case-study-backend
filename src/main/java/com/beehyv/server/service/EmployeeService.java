package com.beehyv.server.service;


import com.beehyv.server.dto.TaskDto;
import com.beehyv.server.entity.Employee;
import com.beehyv.server.entity.Project;
import com.beehyv.server.entity.Task;

import java.util.List;

public interface EmployeeService {
    List<Employee> fetchAllEmployees();

    Employee fetchEmployeeById(Long employeeId);

    List<TaskDto> fetchEmployeesTasks(Long employeeId);

    List<Project> fetchEmployeesProjects(Long employeeId);

}
