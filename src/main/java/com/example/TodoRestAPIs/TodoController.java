package com.example.TodoRestAPIs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    private final TodoService todoService;


    private static List<Todo> todoList;
    public TodoController(TodoService todoService){
        this.todoService = todoService;
        todoList = new ArrayList<>();
        todoList.add(new Todo(1, false, "Todo 1", 1));
        todoList.add(new Todo(2, true, "Todo 2", 2));

    }
    @GetMapping("/")
    public List<Todo> getTodos(){
        return todoList;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getTodos(@RequestParam(required = false, defaultValue = "true") boolean isCompleted){
        System.out.println("Query parameters ars: " + isCompleted + this.todoService.doSomething());
        return  ResponseEntity.ok(todoList);
    }

//ResponseStatus s used to send the status of the request made,
//    instead of this we can also use ResponseEntity
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo){
        todoList.add(newTodo);
//        return newTodo;
        return ResponseEntity.ok().body(newTodo);
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<?> getTodoById(@PathVariable int todoId) {
        for (Todo todo : todoList) {
            if (todo.getId() == todoId) {
                return ResponseEntity.ok(todo);
            }
        }

        Map<String, String> response = new HashMap<>();
        response.put("message", "Todo item with ID " + todoId + " not found");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
