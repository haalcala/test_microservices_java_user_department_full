package com.mycompany.user.service.services;

import com.mycompany.user.service.VO.Department;
import com.mycompany.user.service.VO.ResponseTemplateVO;
import com.mycompany.user.service.entities.User;
import com.mycompany.user.service.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
//@EnableDiscoveryClient
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private DiscoveryClient discoveryClient;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        User user = userRepository.findUserByUserId(userId);

//        List<ServiceInstance> instances = discoveryClient.getInstances("DEPARTMENT_SERVICE");
//
//        String url = instances.get(0).getUri()+"/departments/" + user.getDepartmentId();
        String url = "http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId();

        log.info("Trying to access url:" + url);

        Department department = restTemplate.getForObject(url, Department.class);

        ResponseTemplateVO res = new ResponseTemplateVO();

        res.user = user;
        res.department = department;

        return res;
    }
}
