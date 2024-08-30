package br.com.samira.desafio_todo_list.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.samira.desafio_todo_list.entity.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Long>{
    
}
