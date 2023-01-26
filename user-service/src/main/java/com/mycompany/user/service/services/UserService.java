package com.mycompany.user.service.services;

import com.mycompany.user.service.VO.Department;
import com.mycompany.user.service.VO.ResponseTemplateVO;
import com.mycompany.user.service.entities.User;
import com.mycompany.user.service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        User user = userRepository.findUserByUserId(userId);

        Department department = restTemplate.getForObject("http://localhost:9001/departments/" + user.getDepartmentId(), Department.class);

        ResponseTemplateVO res = new ResponseTemplateVO();

        res.user = user;
        res.department = department;

        return res;
    }
}
