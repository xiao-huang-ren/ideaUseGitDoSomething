package cn.itcast.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;

public class SendTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-rabbitmq-producer.xml");

        System.out.println("这是新增的代码");
        System.out.println("这是新增的代码");
        System.out.println("多人同时操作同一行，出现冲突");
        System.out.println("出现冲突了，已协商解决");
        RabbitTemplate template = context.getBean(RabbitTemplate.class);

        HashMap<String, String> map = new HashMap<>();
        map.put("email","neverGiveUpStudy@code.com");
        template.convertAndSend("msg.email", map);

        context.close();
    }
}
