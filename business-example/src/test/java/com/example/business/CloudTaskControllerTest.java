package com.example.business;

import com.example.business.controller.CloudTaskController;
import com.example.business.domain.CloudTask;
import com.example.business.service.CloudTaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.Arrays;
import java.util.List;



import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @className: CloudTaskControllerTest
 * @description: TODO 类描述
 * @date: 2024/5/15
 **/
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CloudTaskControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @InjectMocks
    private CloudTaskController cloudTaskController;

    @Mock
    private CloudTaskService cloudTaskService;
    private List<CloudTask> tasks;
    @BeforeEach
    public void setUp() {
        // 初始化mockMvc
        mockMvc = MockMvcBuilders.standaloneSetup(cloudTaskController).build();

        // 初始化测试数据
        CloudTask task1 = new CloudTask(/* 初始化task1 */);
        CloudTask task2 = new CloudTask(/* 初始化task2 */);
        tasks = Arrays.asList(task1, task2);

        // 模拟服务层方法的行为
        when(cloudTaskService.getAllCloudTasks()).thenReturn(tasks);
    }
    @Test
    public void testGetAllCloudTasks() throws Exception {
        // 执行请求并验证结果
        mockMvc.perform(get("/api/tasks")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(result -> {
                });
    }
    @Test
    public void testCreateCloudTasks() throws Exception {
        // 执行请求并验证结果
        mockMvc.perform(post("/api/tasks")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(result -> {
                });
    }
}