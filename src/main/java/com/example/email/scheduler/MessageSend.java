package com.example.email.scheduler;

import com.example.email.service.SendMessage;
import com.example.email.util.FileReadUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MessageSend {

    @Resource
    private SendMessage sendMessage;

    //每天早上8点执行一次
    @Scheduled(cron = "0 0 8 * * ?")
    private void sendEmail() throws IOException {

        //获取resource下的员工名单txt文件
        ClassPathResource classPathResource = new ClassPathResource("templates/EmployeeList.txt");
        InputStream inputStream = classPathResource.getInputStream();

        //调用txt工具类，获取员工名单
        List<String> strings = FileReadUtils.readTxt(inputStream);

        //遍历员工名单
        strings.forEach(employee->{
            String[] split = employee.split(",");
            //获取生日
            String birth = split[2];


            LocalDate date1 = LocalDate.now();
            LocalDate date2 = LocalDate.parse(birth, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            MonthDay birthday = MonthDay.of(date2.getMonth(),date2.getDayOfMonth());
            MonthDay currentMonthDay = MonthDay.from(date1);

            String name = split[1];
            String email = split[3];

            //如果今天是生日，发送生日邮件
            if (birthday.equals(currentMonthDay)) {
                sendMessage.sendMessage(email, "生日邮件", name + "生日快乐！");
            }
        });
    }


}
