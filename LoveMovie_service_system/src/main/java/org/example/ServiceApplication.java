package org.example;


import io.github.cdimascio.dotenv.Dotenv;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan("org.example.system.mapper")
public class ServiceApplication {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        System.setProperty("ALIYUN_ACCESS_KEY_ID", dotenv.get("ALIYUN_ACCESS_KEY_ID"));
        System.setProperty("ALIYUN_ACCESS_KEY_SECRET", dotenv.get("ALIYUN_ACCESS_KEY_SECRET"));
        SpringApplication.run(ServiceApplication.class,args);
    }
}
