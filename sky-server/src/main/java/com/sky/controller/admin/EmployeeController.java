package com.sky.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.sky.dto.EmployeeLoginDto;
import com.sky.entity.Employee;
import com.sky.result.Result;
import com.sky.service.EmployeeService;
import com.sky.vo.EmployeeLoginVO;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/admin/employee")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/login")
    public Result<EmployeeLoginVO> login(@RequestBody EmployeeLoginDto employeeLoginDto) {
        
        log.info("员工登录：{}", employeeLoginDto);

        Employee employee = employeeService.login(employeeLoginDto);

        EmployeeLoginVO employeeLoginVO = EmployeeLoginVO.builder()
                .id(employee.getId())
                .username(employee.getUsername())
                .name(employee.getName())
                .build();
        return Result.success(employeeLoginVO);
    }

    @GetMapping("/logout")
    public Result<String> logout() {
        return Result.success();
    }
    
    
}
