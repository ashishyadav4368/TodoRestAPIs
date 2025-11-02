package com.example.TodoRestAPIs;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
@Primary
@Service("fakeTodoService")
public class FakeTodoService implements TodoService{

    @Override
    @TimeMonitor
    public String doSomething() {
        for (int i = 0; i <1000000000 ; i++) {

        }
        return "Dependency injection";
    }
}