package br.com.jeffersondev.desafio_todolist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.jeffersondev.desafio_todolist.entity.Todo;
import br.com.jeffersondev.desafio_todolist.repository.TodoRepository;


@Service
public class TodoService {
    
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(Todo todo){
        todoRepository.save(todo);
        return list();
    }
    public List<Todo> list(){
        Sort sort = Sort.by("prioridade").descending().and(Sort.by("nome").ascending());
        return todoRepository.findAll(sort);
    }
    public List<Todo> update(Long id, Todo todo){
        Optional<Todo> byId = todoRepository.findById(id);
        if (byId.isPresent()) {
            todo.setId(id);
            todoRepository.save(todo);
            return list();

        }else{
            System.out.println("To do não existe!");
            return null;
        }

    }
    public List<Todo> delete(Long id){
        Optional<Todo> byId = todoRepository.findById(id);
        if (byId.isPresent()) {
            todoRepository.deleteById(id);
            return list();

        }else{
            System.out.println("To do não existe!");
            return null;
        }
    }



}
