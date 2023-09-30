/**
 * Author: Ernest Wambua
 * Email: ernestwambua2@gmail.com
 * Date: 9/30/23 : 8:13 AM
 */
package com.tallninja.todoapp.controller.graphql.input.todo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateTodoInput {

    private String title;
    private String description;
    private Boolean done;

}
