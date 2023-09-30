/**
 * Author: Ernest Wambua
 * Email: ernestwambua2@gmail.com
 * Date: 9/30/23 : 8:08 AM
 */
package com.tallninja.todoapp.controller.graphql.input.todo;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class TodoInput {

    private UUID id;

}
