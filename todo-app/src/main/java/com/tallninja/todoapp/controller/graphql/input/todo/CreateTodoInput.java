/**
 * Author: Ernest Wambua
 * Email: ernestwambua2@gmail.com
 * Date: 9/30/23 : 8:10 AM
 */
package com.tallninja.todoapp.controller.graphql.input.todo;

import com.tallninja.todoapp.controller.graphql.input.user.UserInput;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateTodoInput {

    private String title;
    private String description;
    private UserInput user;

}
