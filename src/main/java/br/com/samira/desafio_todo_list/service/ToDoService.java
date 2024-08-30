package br.com.samira.desafio_todo_list.service;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.samira.desafio_todo_list.entity.ToDo;
import br.com.samira.desafio_todo_list.repository.ToDoRepository;

@Service
public class ToDoService {
    private ToDoRepository todoRepository;

    public ToDoService(ToDoRepository toDoRepository){
        this.todoRepository = toDoRepository;
    }

    public List<ToDo> create(ToDo todo){
        todoRepository.save(todo);
        return list();
    }

    public List<ToDo> list(){
        Sort sort = Sort.by("prioridade").descending().and(
            Sort.by("nome").ascending());
        return todoRepository.findAll(sort);
    }

    public List<ToDo> update(ToDo todo){
        todoRepository.save(todo);
        return list();
    }

    public List<ToDo> delete(Long id){
        todoRepository.deleteById(id);
        return  list();
    }

}
