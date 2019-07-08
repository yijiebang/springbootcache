package com.cache.springbootcache.mapper;

import com.cache.springbootcache.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
//@CacheConfig(cacheNames = "emp")//可不用，但是再方法中必须要指定，用了方法可不需要，hide
@CacheConfig(cacheNames = "emp")//可不用，但是再方法中必须要指定，用了方法可不需要，show
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;


    /*1. @Cacheable的几个属性详解：
     *       cacheNames/value：指定缓存组件的名字
     *       key：缓存数据使用的key,可以用它来指定。默认使用方法参数的值，一般不需要指定
     *       keyGenerator：作用和key一样，二选一
     *       cacheManager和cacheResolver作用相同：指定缓存管理器，二选一
     *       condition：指定符合条件才缓存，比如：condition="#id>3"
     *                   也就是说传入的参数id>3才缓存数据
     *      unless：否定缓存，当unless为true时不缓存，可以获取方法结果进行判断
     *      sync：是否使用异步模式*/
    //@Cacheable(cacheNames= "employee",key="#id")
    //@Cacheable(cacheNames= "person",key="#id",condition="#id>3")

    /***
     * 根据id缓存所属信息
     * @param id
     * @return
     */
    @Cacheable(key="#id")
    public Employee findEmployeeById(Integer id) {
        System.out.println("查询id="+id);
        return employeeMapper.findEmployeeById(id);
    }

    /**
     * 缓存key=list
     * @param
     * @return
     */
     @Cacheable(key ="'list'" )
    public List<Employee> findEmployee() {
        System.out.println("查询所有");
        List<Employee> list=new LinkedList<>();
        list=employeeMapper.findEmployee();
        return list;
    }

    /**
     * 清空缓存key=list
     *
     * @param employee
     * @return
     */
    //方法调用前清空所有缓存
   // @CacheEvict(value="accountCache",beforeInvocation=true)
    //方法调用后清空所有缓存
    //@CacheEvict(value="emp",allEntries=true)
    @CacheEvict(allEntries=true)//show
    public int save(Employee employee){
        System.out.println("插入，清空所有缓存");
        return employeeMapper.insert(employee);
    }


    //方法调用后清空所有缓存
    //@CacheEvict(value="emp",allEntries=true)
    @CacheEvict(allEntries=true)//show
    public int delete(Integer id){
        System.out.println("删除:"+id+"的信息，清空#id缓存");
        return employeeMapper.delete(id);
    }

}
