package com.mgj.newsdemo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsdemoApplicationTests {


    @Autowired
    private JavaMailSender javaMailSender;

    @Test
    public  void  contextLoads() throws MessagingException {
        MimeMessage mimeMessage =javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        // 发送方邮箱
        helper.setFrom("magj@yuanian.com");
        // 接收方邮箱
//        helper.setTo("wangyq@yuanian.com");
        helper.setTo("15571300605@163.com");
        //抄送
//        String[] cs={"wangmh@yuanian.com","qiugch@yuanian.com"};
//        helper.setCc(cs);

        MailNews mn=new MailNews();
        String str=mn.getmsg("top");

        String str1="新闻列表如下：";
        helper.setSubject("春蕾学员培训-新闻-马广交"+new Date().toString());
        helper.setText(str1+"<table border=\\\"2\\\" style=\\\"border:solid 1px #E8F2F9;font-size=14px;>" +
                "<tr style=\\\"background-color: #428BCA; color:#ffffff\\\">" +
                "<th>标题</th><th>时间</th><th>类型</th><th>作者</th><th>url</th><th>图片1</th><th>图片2</th></tr>" +
                str +
                "</table>",true);
        javaMailSender.send(mimeMessage);
    }


}
