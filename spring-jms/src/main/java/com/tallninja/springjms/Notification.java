/**
 * Author: Ernest Wambua
 * Email: ernestwambua2@gmail.com
 * Date: 9/30/23 : 5:39 PM
 */
package com.tallninja.springjms;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Notification implements Serializable {

    private LocalDate date;
    private LocalTime time;
    private NotificationType type;
    private String message;

    public Notification(LocalDate date, LocalTime time, NotificationType type, String message) {
        this.date = date;
        this.time = time;
        this.type = type;
        this.message = message;
    }

    public Notification() {}

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "date=" + date +
                ", time=" + time +
                ", type=" + type +
                ", message='" + message + '\'' +
                '}';
    }
}
