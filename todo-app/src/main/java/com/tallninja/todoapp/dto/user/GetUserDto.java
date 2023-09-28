/**
 * Author: Ernest Wambua
 * Email: ernestwambua2@gmail.com
 * Date: 9/28/23 : 10:35 AM
 */
package com.tallninja.todoapp.dto.user;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class GetUserDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String displayPicture;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
