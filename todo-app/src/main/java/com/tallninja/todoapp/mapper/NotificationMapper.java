/**
 * Author: Ernest Wambua
 * Email: ernestwambua2@gmail.com
 * Date: 9/30/23 : 6:29 PM
 */
package com.tallninja.todoapp.mapper;

import com.tallninja.todoapp.domain.Notification;
import com.tallninja.todoapp.dto.notification.NotificationPayload;
import org.springframework.stereotype.Component;

@Component
public class NotificationMapper {

    public Notification toNotification(NotificationPayload notificationPayload) {
        return Notification.builder()
                .date(notificationPayload.getDate())
                .time(notificationPayload.getTime())
                .type(notificationPayload.getType())
                .message(notificationPayload.getMessage())
                .read(false)
                .build();
    }

}
