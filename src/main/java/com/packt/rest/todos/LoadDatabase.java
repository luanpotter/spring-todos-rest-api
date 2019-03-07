package com.packt.rest.todos;

import com.packt.rest.todos.todo.Todo;
import com.packt.rest.todos.todo.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(TodoRepository repository) {
		return args -> {
			repository.save(new Todo("todo 1"));
			repository.save(new Todo("todo 2"));
		};
	}
}