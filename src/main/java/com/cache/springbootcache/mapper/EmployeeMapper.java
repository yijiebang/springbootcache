package com.cache.springbootcache.mapper;/**
 * @program: springbootcache
 * @description
 * @author: Jerry Yi
 * @create: 2019-07-07 21:43
 **/

import com.cache.springbootcache.bean.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @author: Jerry Yi
 * @date: 2019/7/7 21:43
 * @description:
 */
@Mapper
public interface EmployeeMapper {

      @Select("select * from employee where id=#{id}")
      Employee findEmployeeById(Integer id);

     @Select("select * from employee")
     List<Employee> findEmployee();

      @Insert("INSERT INTO employee(d_id,email,gender,last_name) VALUES(#{dId}, #{email},#{gender},#{lastName})")
      int insert(Employee employee);

      @Delete("delete from employee where id=#{id}")
      int delete(Integer id);
}
