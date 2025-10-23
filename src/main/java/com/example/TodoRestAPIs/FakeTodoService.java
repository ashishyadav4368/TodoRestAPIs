package com.example.TodoRestAPIs;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
@Primary
@Service
public class FakeTodoService implements TodoService{
    @Override
    public String doSomething() {
        return "Dependency injection";
    }
}
