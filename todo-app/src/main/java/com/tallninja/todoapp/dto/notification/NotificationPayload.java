/**
 * Author: Ernest Wambua
 * Email: ernestwambua2@gmail.com
 * Date: 9/30/23 : 6:13 PM
 */
package com.tallninja.todoapp.dto.notification;

import com.tallninja.todoapp.domain.NotificationType;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class NotificationPayload implements Serializable {

    private NotificationType type;
    private LocalDate date;
    private LocalTime time;
    private String message;

}
