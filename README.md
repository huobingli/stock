# stock

#### Mysql配置 （配置数据源）
```
driver=com.mysql.jdbc.Driver
spring.datasource.driverClassName = com.mysql.jdbc.Driver
spring.datasource.url = jdbc:mysql://127.0.0.1:3306/stock?useUnicode=true&characterEncoding=utf-8
spring.datasource.username = root
spring.datasource.password = 123456
```

#### Mybatis 配置 （配置对数据源的操作 CRUD）
```
interface
interface_name.xml
```
```
@MapperScan(value = "com.stock.project.dao")   ===> 把 interface 变成一个 bean 托管给 spring
mybatis.mapperLocations=classpath:mapper/*.xml
```

####  mybatis 逆向工程
实现一些简单的mysql语句的生成

### plugin
#### lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)

### 注解
@AutoWired
@Component

@RequestMapping
@RequestBody

@AcrossOrigin       处理跨域请求 CORS

### 打包
mvn package