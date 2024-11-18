package com.beehyv.server.service;

import com.beehyv.server.dto.TaskDto;
import com.beehyv.server.entity.Employee;
import com.beehyv.server.entity.Project;
import com.beehyv.server.entity.Task;
import com.beehyv.server.repository.EmployeeRepository;
import com.beehyv.server.repository.ProjectRepository;
import com.beehyv.server.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Employee> fetchAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee fetchEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    @Override
    public List<TaskDto> fetchEmployeesTasks(Long employeeId) {
        List<Long> taskIds = employeeRepository.findEmployeesTaskIds(employeeId);
        List<TaskDto> tasks = new ArrayList<>();
        for(Long taskId: taskIds) {
            Task task = taskRepository.findById(taskId).orElse(null);
            Long projectId = projectRepository.findProjectIdByTaskId(taskId);
            Project project = projectRepository.findById(projectId).orElse(null);
            TaskDto taskDto = new TaskDto();
            if(task != null) {
                taskDto.setId(task.getId());
                taskDto.setTitle(task.getTitle());
                taskDto.setDescription(task.getDescription());
                taskDto.setDate(task.getDate());
                taskDto.setDuration(task.getDuration());
                taskDto.setAppraisalStatus(task.getAppraisalStatus());
            }
            if(project != null) {
                taskDto.setProjectId(project.getId());
                taskDto.setProjectName(project.getName());
            }
            tasks.add(taskDto);
        }
        return tasks;
    }

    @Override
    public List<Project> fetchEmployeesProjects(Long employeeId) {
        List<Long> projectIds = employeeRepository.findEmployeesProjectIds(employeeId);
        List<Project> projects = new ArrayList<>();
        for(Long projectId: projectIds) {
            Project project = projectRepository.findById(projectId).orElse(null);
            projects.add(project);
        }
        return projects;
    }

}
