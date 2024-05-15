package com.example.business.repository;

import com.example.business.domain.CloudTask;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @className: CloudTaskRepository
 * @description: TODO 类描述
 * @date: 2024/5/15
 **/
public interface CloudTaskRepository extends JpaRepository<CloudTask, Integer> {

}