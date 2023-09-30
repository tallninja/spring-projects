/**
 * Author: Ernest Wambua
 * Email: ernestwambua2@gmail.com
 * Date: 9/30/23 : 6:25 PM
 */
package com.tallninja.todoapp.service.implementation;

import com.tallninja.todoapp.domain.Notification;
import com.tallninja.todoapp.dto.notification.NotificationPayload;
import com.tallninja.todoapp.mapper.NotificationMapper;
import com.tallninja.todoapp.repository.NotificationRepository;
import com.tallninja.todoapp.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    public NotificationServiceImpl(
            NotificationRepository notificationRepository,
            NotificationMapper notificationMapper
    ) {
        this.notificationRepository = notificationRepository;
        this.notificationMapper = notificationMapper;
    }

    @Override
    @JmsListener(destination = "notifications")
    public void onMessage(NotificationPayload payload) {
        log.info("[NOTIFICATION] %s".formatted(payload.getMessage()));
        Notification notification = notificationMapper.toNotification(payload);
        notificationRepository.save(notification);
    }

    @Override
    public List<Notification> findAll() {
        return notificationRepository.findAll();
    }
}
