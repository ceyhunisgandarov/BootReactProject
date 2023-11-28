package org.learn.bootreactproject.response;

import org.springframework.http.HttpStatus;

public class ResponseEntityClass <T>{

    private HttpStatus status;
    private T t;

}
