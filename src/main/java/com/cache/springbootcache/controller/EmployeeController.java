package com.cache.springbootcache.controller;/**
 * @program: springbootcache
 * @description
 * @author: Jerry Yi
 * @create: 2019-07-07 21:42
 **/

import com.cache.springbootcache.bean.Employee;
import com.cache.springbootcache.mapper.EmployeeJpa;
import com.cache.springbootcache.mapper.EmployeeMapper;
import com.cache.springbootcache.mapper.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.ValueExp;
import java.util.List;

/**
 * @author: Jerry Yi
 * @date: 2019/7/7 21:42
 * @description:
 */
@RestController     //等同于同时加上了@Controller和@ResponseBody
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;//使用mybatis

    @Autowired
    EmployeeJpa employeeJpa;//使用jpa

    @GetMapping("/emp")
    public List<Employee>  findEmployee(){
        List<Employee> list= employeeService.findEmployee();
        return list;
    }

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable Integer id){
        Employee emp = employeeService.findEmployeeById(id);
        return emp;
    }

    /**
     * 使用mybatis,新增信息
     * @return
     */
    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public String insert(@RequestParam Integer did,@RequestParam String email,@RequestParam String gender,@RequestParam String lastname) {
        Employee employee = new Employee();
        employee.setDId(did);
        employee.setEmail(email);
        employee.setGender(gender);
        employee.setLastName(lastname);
       int c= employeeService.save(employee);
       System.out.println(c);
        return "success";

    }

    @GetMapping(value = {"deletem/{id}"})
    public int deletem(@PathVariable Integer id){
        int c=employeeService.delete(id);
        return c;
    }

    /**
     * 使用jpa查询所有信息
     * @return
     */
    @GetMapping(value = "getList")
    public List<Employee> getList(){
        List<Employee> list=employeeJpa.findAll();
        return list;
    }

    /**
     * 使用jpa,新增信息
     * @return
     */
    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    public String save(@RequestParam String email,@RequestParam String gender,@RequestParam String lastname) {
        Employee employee = new Employee();
        employee.setEmail(email);
        employee.setGender(gender);
        employee.setLastName(lastname);
        employeeJpa.save(employee);

        return "success";

    }

    /**
     * 使用jpa,根据id删除信息
     * @return
     */
    @RequestMapping(value = "delet",method = RequestMethod.GET)
    public String delete(Integer id){
        employeeJpa.deleteById(id);

        return "删除成功";
    }


}
