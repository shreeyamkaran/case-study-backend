package com.beehyv.server.service;

import com.beehyv.server.dto.TaskDto;
import com.beehyv.server.entity.Task;
import com.beehyv.server.repository.ProjectRepository;
import com.beehyv.server.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Task> fetchAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task fetchTaskById(Long taskId) {
        return taskRepository.findById(taskId).orElse(null);
    }

    @Override
    public void updateTask(Long taskId, TaskDto task) {
        Task previousTask = taskRepository.findById(taskId).orElse(null);
        if(previousTask != null) {
            previousTask.setTitle(task.getTitle());
            previousTask.setDescription(task.getDescription());
            previousTask.setDate(task.getDate());
            previousTask.setDuration(task.getDuration());
            previousTask.setAppraisalStatus(task.getAppraisalStatus());
            projectRepository.updateProjectByTaskId(task.getProjectId(), taskId);
        }
    }

    @Override
    public void createTask(Long employeeId, TaskDto taskDto) {
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setDate(taskDto.getDate());
        task.setDuration(taskDto.getDuration());
        task.setAppraisalStatus(taskDto.getAppraisalStatus());
        Task createdTask = taskRepository.save(task);
        taskRepository.mapTaskIdWithEmployeeId(createdTask.getId(), employeeId);
        taskRepository.mapTaskIdWithProjectId(createdTask.getId(), taskDto.getProjectId());
    }

}
