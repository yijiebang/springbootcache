# springbootcache
springboot+web+mysql+mybatis+jpa+cache+redis
springboot缓存功能

使用cache

1.开始使用前需要导入依赖
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-cache</artifactId>
</dependency>
2.然后在启动类注解@EnableCaching开启缓存
@SpringBootApplication
@EnableCaching  //开启缓存
public class DemoApplication{

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

3.缓存@Cacheable
@Cacheable(value = "emp" ,key = "targetClass + methodName +#p0")             .value等同于cacheNames ，可在类上面定义
    public List<NewJob> queryAll(User uid) {
        return newJobDao.findAllByUid(uid);
    }


4.配置@CacheConfig
@CacheConfig(cacheNames = {"myCache"})
public class BotRelationServiceImpl implements BotRelationService {
    @Override
    @Cacheable(key = "targetClass + methodName +#p0")//此处没写value
    方法{}
}

5.更新@CachePut
@CachePut(value = "emp", key = "targetClass + #p0")

6.清除@CacheEvict
  //清除一条缓存，key为要清空的数据
    @CacheEvict(value="emp",key="#id")
    public void delect(int id) {
        newJobDao.deleteAllById(id);
    }

    //方法调用后清空所有缓存
    @CacheEvict(value="accountCache",allEntries=true)
    public void delectAll() {
        newJobDao.deleteAll();
    }

    //方法调用前清空所有缓存
    @CacheEvict(value="accountCache",beforeInvocation=true)
    public void delectAll() {
        newJobDao.deleteAll();
    }
