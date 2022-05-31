package io.hoon.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request")
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + this.uuid + "] " + "[" + this.requestURL + "] " + "[" + message + "] ");
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + this.uuid + "] request scope bean create : " + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[" + this.uuid + "] request scope bean close : " + this);
    }
}
