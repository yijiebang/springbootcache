package com.cache.springbootcache.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @program: springbootcache
 * @description
 * @author: Jerry Yi
 * @create: 2019-07-07 21:36
 **/
@Entity //声明一个实体，用的是Java规范下的注解
@Table(name = "Employee") //映射的表名称
@Data    // get set toString 等方法
public class Employee implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String lastName;
    private String gender;
    private String email;
    private Integer dId;

}
