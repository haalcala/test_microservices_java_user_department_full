package com.mycompany.user.service.VO;

import com.mycompany.user.service.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    public User user;
    public Department department;
}
