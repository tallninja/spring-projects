/**
 * Author: Ernest Wambua
 * Email: ernestwambua2@gmail.com
 * Date: 9/30/23 : 4:36 PM
 */
package com.tallninja.springjms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsProducer {

    private final JmsTemplate jmsTemplate;
    private final Logger log = LoggerFactory.getLogger(JmsProducer.class);

    public JmsProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(String destination, Notification notification) {
        log.info("Sending notification: %s".formatted(notification));
        jmsTemplate.convertAndSend(destination, notification);
    }

}
