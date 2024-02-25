package org.sparta.post_lv1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // 꼭 달아줘야 createdAt기능 수행
@SpringBootApplication
public class PostLv1Application {

    public static void main(String[] args) {
        SpringApplication.run(PostLv1Application.class, args);
    }

}
