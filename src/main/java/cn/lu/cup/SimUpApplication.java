package cn.lu.cup;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Demo project for Spring Cloud
 *
 * @author waterlu
 * @date 2018-04-03
 */
@SpringBootApplication
//@MapperScan("cn.lu.cup.mapper")
public class SimUpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimUpApplication.class, args);
    }
}