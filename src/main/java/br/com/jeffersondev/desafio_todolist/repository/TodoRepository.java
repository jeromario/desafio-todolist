package br.com.jeffersondev.desafio_todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jeffersondev.desafio_todolist.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{

}
