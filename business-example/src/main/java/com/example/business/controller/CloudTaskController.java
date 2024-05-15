package com.example.business.controller;

import com.example.business.domain.CloudTask;

import com.example.business.service.CloudTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @className: CloudTaskController
 * @description: TODO 类描述
 * @date: 2024/5/15
 **/
@RestController
@RequestMapping("/api/tasks")
public class CloudTaskController {

    @Autowired
    private CloudTaskService cloudTaskService;


    @PostMapping
    public ResponseEntity<CloudTask> createTask(@RequestBody CloudTask task) {
        CloudTask savedTask = cloudTaskService.saveCloudTask(task);
        return ResponseEntity.ok(savedTask);
    }


    @GetMapping
    public ResponseEntity<List<CloudTask>> getAllTasks() {
        List<CloudTask> tasks = cloudTaskService.getAllCloudTasks();
        return ResponseEntity.ok(tasks);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CloudTask> getTaskById(@PathVariable Integer id) {
        CloudTask task = cloudTaskService.getCloudTaskById(id);
        return ResponseEntity.ok(task);
    }


    @PutMapping("/{id}")
    public ResponseEntity<CloudTask> updateTask(@PathVariable Integer id, @RequestBody CloudTask updatedTask) {
        if (!cloudTaskService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedTask.setId(id);
        CloudTask savedTask = cloudTaskService.saveCloudTask(updatedTask);
        return ResponseEntity.ok(savedTask);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Integer id) {
        if (cloudTaskService.existsById(id)) {
            cloudTaskService.deleteTaskById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}