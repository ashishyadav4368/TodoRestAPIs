package com.example.TodoRestAPIs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {
    private static List<Todo> todoList;
    public TodoController(){
        todoList = new ArrayList<>();
        todoList.add(new Todo(1, false, "Todo 1", 1));
        todoList.add(new Todo(2, true, "Todo 2", 2));
    }
    @GetMapping("/todos")
    public List<Todo> getTodos(){
        return todoList;
    }
//ResponseStatus s used to send the status of the request made,
//    instead of this we can also use ResponseEntity
    @PostMapping("/todos")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo){
        todoList.add(newTodo);
//        return newTodo;
        return ResponseEntity.ok().body(newTodo);
    }
}
