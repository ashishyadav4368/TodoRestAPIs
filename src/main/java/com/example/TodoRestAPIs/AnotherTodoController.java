package com.example.TodoRestAPIs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnotherTodoController {
    private final TodoService todoService;
    public AnotherTodoController(@Qualifier("anotherTodoService") TodoService todoService){
            this.todoService = todoService;
    }

    @GetMapping("/abc")
    public void ABC(){
        System.out.println(this.todoService.doSomething());
    }
}
