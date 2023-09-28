/**
 * Author: Ernest Wambua
 * Email: ernestwambua2@gmail.com
 * Date: 9/28/23 : 11:32 AM
 */
package com.tallninja.todoapp.dto.todo;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateTodoDto {

    @NotNull
    private String title;

    private String description;

    @NotNull
    private Boolean done;

}
