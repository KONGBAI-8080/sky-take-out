package com.sky.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sky.constant.MessageConstant;
import com.sky.constant.StatusConstant;
import com.sky.dto.EmployeeLoginDto;
import com.sky.entity.Employee;
import com.sky.exception.AccountLockedException;
import com.sky.exception.AccountNotFoundException;
import com.sky.exception.PasswordErrorException;
import com.sky.mapper.EmployeeMapper;
import com.sky.service.EmployeeService;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee login(EmployeeLoginDto employeeLoginDto) {

        String username = employeeLoginDto.getUsername();
        String password = employeeLoginDto.getPassword();

        // 根据用户名找到员工
        Employee employee = employeeMapper.getByUsername(username);

        // 如果找不到员工报错
        if(employee == null){
            // throw new RuntimeException("该员工"+username+"不存在！");
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }
        // 如果员工的密码是错误的也报错
        if(!password.equals(employee.getPassword())){
            // throw new RuntimeException("密码错误，请重新输入！");
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        // 如果员工是被锁定的也报错
        if(employee.getStatus()==StatusConstant.DISABLE){
            // throw new RuntimeException("该员工被锁定！");
            throw new AccountLockedException(MessageConstant.ACCOUNT_LOCKED);
        }

        return employee;
    }

    
}