package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing//JPA Auditing 활성화 (@WebMvcTest 에서는 에러가 나기때문에 분리)
@SpringBootApplication
public class Application {
    public static void main(String[] ags){
        SpringApplication.run(Application.class, ags);
    }
}
