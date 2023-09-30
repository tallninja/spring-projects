package com.tallninja.springjms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;

import java.time.LocalDate;
import java.time.LocalTime;

@EnableJms
@SpringBootApplication
public class SpringJmsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringJmsApplication.class, args);

        JmsProducer producer = context.getBean(JmsProducer.class);
        producer.sendMessage(
                "notifications",
                new Notification(
                        LocalDate.now(),
                        LocalTime.now(),
                        NotificationType.ERROR,
                        "Unknown Error Occurred!"
                ));
    }

}
