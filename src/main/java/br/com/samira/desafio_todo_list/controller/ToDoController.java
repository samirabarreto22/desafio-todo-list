package br.com.samira.desafio_todo_list.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.samira.desafio_todo_list.entity.ToDo;
import br.com.samira.desafio_todo_list.service.ToDoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/todos")
public class ToDoController {
    private ToDoService todoService;

    public ToDoController(ToDoService todoService){
        this.todoService = todoService;
    }
    
    @PostMapping
    List<ToDo> create( @RequestBody @Valid ToDo todo){
        return todoService.create(todo);
    }

    @GetMapping
    List<ToDo> list(){
        return todoService.list();
    }

    @PutMapping
    List<ToDo> update(@RequestBody ToDo todo){
        return todoService.update(todo);
    }

    @DeleteMapping("{id}")
    List<ToDo> delete(@PathVariable("id") Long id){
        return  todoService.delete(id);
    }
    
}
