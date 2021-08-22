package com.example.email;

import com.example.email.service.SendMessage;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class EmailApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    private SendMessage sendMessage;
    @Test
    void testEmail(){
        sendMessage.sendMessage("1614277914@qq.com","生日快乐","道长生日快乐");
    }

}
