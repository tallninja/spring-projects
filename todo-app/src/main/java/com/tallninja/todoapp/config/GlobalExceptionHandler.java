/**
 * Author: Ernest Wambua
 * Email: ernestwambua2@gmail.com
 * Date: 9/30/23 : 11:38 AM
 */
package com.tallninja.todoapp.config;

import graphql.GraphQLError;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.net.BindException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @GraphQlExceptionHandler
    public GraphQLError handle(Exception exception) {
        return GraphQLError.newError()
                .errorType(ErrorType.INTERNAL_ERROR)
                .message(exception.getLocalizedMessage())
                .build();
    }

}
