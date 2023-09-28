/**
 * Author: Ernest Wambua
 * Email: ernestwambua2@gmail.com
 * Date: 9/28/23 : 11:23 AM
 */
package com.tallninja.todoapp.dto.todo;

import com.tallninja.todoapp.domain.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateTodoDto {
    @NotBlank
    @NotNull
    private String title;

    private String description;

    @NotNull
    private User user;
}
