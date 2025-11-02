package com.example.TodoRestAPIs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

//so here dependency injection can be done in two ways, either we do constructor dependency injection
// or we can use @Autowired and define which dependency to be injected outside of the constructor
// this is done using @Autowired
//public class AnotherTodoController {
//    @Autowired
//    @Qualifier("anotherTodoService")
//    private final TodoService todoService;
//    public AnotherTodoController(TodoService todoService){
//            this.todoService = todoService;
//    }
//
//    @GetMapping("/abc")
//    public void ABC(){
//        System.out.println(this.todoService.doSomething());
//    }
//}

// doing dependency injection  using constructor
//both the methods are doing the same work
public class AnotherTodoController {


    private final TodoService todoService;
    public AnotherTodoController( @Qualifier("anotherTodoService") TodoService todoService){
        this.todoService = todoService;
    }

    @GetMapping("/abc")
    public void ABC(){
        System.out.println(this.todoService.doSomething());
    }
}
