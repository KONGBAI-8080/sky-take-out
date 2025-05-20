package com.sky.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sky.dto.EmployeeLoginDto;
import com.sky.entity.Employee;

public interface EmployeeService extends IService<Employee>{
    
    /**
     * 员工登录
     * @param employeeLoginDto
     */
    Employee login(EmployeeLoginDto employeeLoginDto);
    
}
