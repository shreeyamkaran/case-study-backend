package com.beehyv.server.service;

import com.beehyv.server.dto.TaskDto;
import com.beehyv.server.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> fetchAllTasks();

    Task fetchTaskById(Long taskId);

    void updateTask(Long taskId, TaskDto task);

    void createTask(Long employeeId, TaskDto task);
}
