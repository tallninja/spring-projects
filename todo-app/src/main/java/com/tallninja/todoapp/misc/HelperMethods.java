/**
 * Author: Ernest Wambua
 * Email: ernestwambua2@gmail.com
 * Date: 9/30/23 : 6:38 PM
 */
package com.tallninja.todoapp.misc;

import com.tallninja.todoapp.domain.NotificationType;
import com.tallninja.todoapp.dto.notification.NotificationPayload;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class HelperMethods {

    public static NotificationPayload createNotificationPayload(NotificationType type, String message) {
        return NotificationPayload.builder()
                .date(LocalDate.now())
                .time(LocalTime.now())
                .type(type)
                .message(message)
                .build();
    }

}
