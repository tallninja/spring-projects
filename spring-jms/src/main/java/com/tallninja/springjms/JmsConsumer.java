/**
 * Author: Ernest Wambua
 * Email: ernestwambua2@gmail.com
 * Date: 9/30/23 : 4:36 PM
 */
package com.tallninja.springjms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsConsumer {

    private final Logger log = LoggerFactory.getLogger(JmsConsumer.class);

    @JmsListener(destination = "notifications")
    public void receiveMessage(Notification notification) {
        log.info("Received notification: %s".formatted(notification));
    }

}
