/**
 * Author: Ernest Wambua
 * Email: ernestwambua2@gmail.com
 * Date: 9/28/23 : 11:29 AM
 */
package com.tallninja.todoapp.dto.todo;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class GetTodoDto {
    private UUID id;
    private String title;
    private String description;
    private Boolean done;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
