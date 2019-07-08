package com.cache.springbootcache.mapper;/**
 * @program: springbootcache
 * @description
 * @author: Jerry Yi
 * @create: 2019-07-07 22:36
 **/

import com.cache.springbootcache.bean.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: Jerry Yi
 * @date: 2019/7/7 22:36
 * @description:
 */
public interface EmployeeJpa extends JpaRepository<Employee,Integer> {


}
