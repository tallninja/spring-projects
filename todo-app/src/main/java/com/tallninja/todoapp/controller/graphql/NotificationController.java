/**
 * Author: Ernest Wambua
 * Email: ernestwambua2@gmail.com
 * Date: 9/30/23 : 6:53 PM
 */
package com.tallninja.todoapp.controller.graphql;

import com.tallninja.todoapp.domain.Notification;
import com.tallninja.todoapp.service.NotificationService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @QueryMapping
    public List<Notification> notifications() {
        return notificationService.findAll();
    }

}
