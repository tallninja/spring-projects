/**
 * Author: Ernest Wambua
 * Email: ernestwambua2@gmail.com
 * Date: 9/30/23 : 8:16 AM
 */
package com.tallninja.todoapp.controller.graphql.input.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateUserInput {

    private String firstName;
    private String lastName;
    private String email;

}
