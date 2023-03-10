package com.mycompany.department.controller;

import com.mycompany.department.entities.Department;
import com.mycompany.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department) {
        log.info("DepartmentController.saveDepartment::");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId) {
        log.info("DepartmentController.findDepartmentById::");
        return departmentService.findDepartmentById(departmentId);
    }
}
