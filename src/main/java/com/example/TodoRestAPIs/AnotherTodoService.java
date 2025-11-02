package com.example.TodoRestAPIs;

import org.springframework.stereotype.Service;

//so here there are two classes (FakeTodoService, AnotherTodoService) which implements same TodoService
// so now when spring will create objects then it will be collision
// here spring doesn't know which bean is to be injected then it comes @Primary annotation
@Service("anotherTodoService")
public class AnotherTodoService implements TodoService {
    @Override
    public String doSomething(){
        return "Do something from another todo service";
    }
}
