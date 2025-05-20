package com.sky.mapper;



import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sky.entity.Employee;

public interface EmployeeMapper extends BaseMapper<Employee>{
    /**
     * 用用户名字段查找员工
     * @param username
     * @return
     */
    @Select("selct * from employee where username = #{username}")
    Employee getByUsername(String username);
}
