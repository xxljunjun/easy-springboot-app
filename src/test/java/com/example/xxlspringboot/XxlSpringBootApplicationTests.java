package com.example.xxlspringboot;

import com.example.xxlspringboot.utils.result.ResultEnum;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class XxlSpringBootApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(ResultEnum.valueOf("SUCCESS"));
    }

}
