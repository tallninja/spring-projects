/**
 * Author: Ernest Wambua
 * Email: ernestwambua2@gmail.com
 * Date: 9/30/23 : 6:20 PM
 */
package com.tallninja.todoapp.service;

import com.tallninja.todoapp.domain.Notification;
import com.tallninja.todoapp.dto.notification.NotificationPayload;

import java.util.List;

public interface NotificationService {
    void onMessage(NotificationPayload payload);

    List<Notification> findAll();
}
