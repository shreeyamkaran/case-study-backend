package com.beehyv.server.controller;

import com.beehyv.server.dto.TaskDto;
import com.beehyv.server.entity.Employee;
import com.beehyv.server.entity.Project;
import com.beehyv.server.entity.Task;
import com.beehyv.server.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/api/v1/employees")
    public List<Employee> fetchAllEmployees() {
        return employeeService.fetchAllEmployees();
    }

    @GetMapping("/api/v1/employees/{employee-id}")
    public Employee fetchEmployeeById(@PathVariable("employee-id") Long employeeId) {
        return employeeService.fetchEmployeeById(employeeId);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/api/v1/employees/{employee-id}/tasks")
    public List<TaskDto> fetchEmployeesTasks(@PathVariable("employee-id") Long employeeId) {
        return employeeService.fetchEmployeesTasks(employeeId);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/api/v1/employees/{employee-id}/projects")
    private List<Project> fetchEmployeesProjects(@PathVariable("employee-id") Long employeeId) {
        return employeeService.fetchEmployeesProjects(employeeId);
    }

}
