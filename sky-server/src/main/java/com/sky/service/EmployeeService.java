package com.sky.service;

import com.sky.dto.EmployeeLoginDto;

public interface EmployeeService {
    
    /**
     * 员工登录
     * @param employeeLoginDto
     */
    void login(EmployeeLoginDto employeeLoginDto);
    
}
