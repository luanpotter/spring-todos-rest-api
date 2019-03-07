package xyz.luan.rest.todos;

import xyz.luan.rest.todos.todo.Todo;
import xyz.luan.rest.todos.todo.TodoRepository;
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