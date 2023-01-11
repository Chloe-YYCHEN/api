## Hi，这是一个SpringBoot + H2 + JPA的项目
<p>一、各个文件包的作用</p>

### 1.com.example.api
<div>
<p>configuration：</p>
<p>JsonPlaceHolderConfiguration添加bean管理配置json数据</p>
<p>controller：</p>
<p>CustomerController为version1版本，CustomerControllerV2为version2版本</p>
<p>repository：</p>
<p>CustomerFakeRepository为模拟数据库，CustomerRepo和CustomerRepository为接口这里就不过多赘述了</p>
<p>service：</p>
<p>CustomerService内有两个方法getCustomers和getCustomer</p>
<p>getCustomers使用了CustomerRepository里的方法findAll</p>
<p>getCustomer使用了CustomerRepository的findById方法并使用java.util.Optional类的orElseThrow()方法用于获取值,如果实例中不存在任何值，则此方法将引发notFoundException异常</p>
<p>exception：</p>
<p>此包将用于定义各种异常</p>
<p>entity：</p>
<p>实体类</p>
<p>@Entity：Spring Data JPA中实体类常用的注解，主要定义JPA中的实体，管理实体之间的关系</p>
<p>@Table：用来说明该实体类对应的表和数据库</p>
</div>

二、properties的相关说明
application.properties
```properties
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=root
spring.datasource.password=
#配置h2数据库
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.show-sql=true
#dialect：设置数据库引擎为H2Dialect
spring.h2.console.enabled=true
spring.h2.console.path=/h2
#配置h2数据库路径
logging.level.com.example.api=info
#slf4j的logger输出等级
spring.main.banner-mode=off
#关闭 Banner
spring.jackson.serialization.fail-on-empty-beans=false
#是否开启jackson的序列化.（一般使用jackjson将对象json化）
info.app.name=Spring Boot Master Class
info.app.description=Master Spring Boot
info.app.version=1.0.0
info.company.name=Google

management.endpoint.health.show-details=always
#检查正在运行的应用程序的状态的详细信息显示给所有用户。
management.endpoints.web.exposure.include=health,info,prometheus
#actuator端点启用和暴露，通过HTTP公开所有的端点，包含health,info,prometheus端点
```
application-dev.properties
一般用于表示为开发环境。
<p>prod--生产环境，直接面对用户</p>
<p>test--测试环境</p>
<p>更细一点：</p>
<p>SIT：系统集成测试环境</p>
<p>UAT：用户验收测试环境</p>
------------------------------------------END----------------------------------------