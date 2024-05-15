package com.example.business.service;

import com.example.business.domain.CloudTask;
import com.example.business.repository.CloudTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @className: CloudTaskService
 * @description: TODO 类描述
 * @date: 2024/5/15
 **/
@Service
public class CloudTaskService {

    private final CloudTaskRepository cloudTaskRepository;

    /**
     * 构造函数
     *
     * @param cloudTaskRepository
     */
    @Autowired
    public CloudTaskService(CloudTaskRepository cloudTaskRepository) {
        this.cloudTaskRepository = cloudTaskRepository;
    }

    /**
     * 保存云任务
     *
     * @param cloudTask
     * @return
     */
    public CloudTask saveCloudTask(CloudTask cloudTask) {
        return cloudTaskRepository.save(cloudTask);
    }

    /**
     * 获取所以云任务
     *
     * @return
     */
    public List<CloudTask> getAllCloudTasks() {
        return cloudTaskRepository.findAll();
    }

    /**
     * 根据id获取云任务
     *
     * @param id
     * @return
     */
    public CloudTask getCloudTaskById(Integer id) {
        return cloudTaskRepository.findById(id).orElse(null);
    }


    /**
     * 更新云任务
     *
     * @param id
     * @param updatedCloudTask
     * @return
     */
    public CloudTask updateCloudTask(Integer id, CloudTask updatedCloudTask) {
        CloudTask cloudTask = cloudTaskRepository.findById(id).orElse(null);
        if (cloudTask != null) {
            cloudTask.setName(updatedCloudTask.getName());
            cloudTask.setDescription(updatedCloudTask.getDescription());
            cloudTask.setStatus(updatedCloudTask.getStatus());
            return cloudTaskRepository.save(cloudTask);
        }
        return null;
    }


    /**
     * 根据id判断云任务是否存在
     *
     * @param id
     * @return
     */
    public boolean existsById(Integer id) {
        return cloudTaskRepository.existsById(id);
    }


    /**
     * 根据id删除云任务
     *
     * @param id
     */
    public void deleteTaskById(Integer id) {
        cloudTaskRepository.deleteById(id);
    }
}