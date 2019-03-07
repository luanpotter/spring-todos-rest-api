package xyz.luan.rest.todos.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
public class TodoApi {

	private final TodoRepository repository;

	@Autowired
	public TodoApi(TodoRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/todos")
	public List<Todo> listTodos() {
		return repository.findAll();
	}

	@GetMapping("/todos/:id")
	public Todo findTodo(@PathParam("id") Long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/todos")
	public Todo createNewTodo(@RequestBody Todo todo) {
		todo.setId(null);
		return repository.save(todo);
	}

	@PostMapping("/todos/:id")
	public Todo createNewTodoWithId(@PathParam("id") Long id, @RequestBody Todo todo) {
		if (repository.findById(id).isPresent()) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Id already exists");
		}
		todo.setId(id);
		return repository.save(todo);
	}

	@PutMapping("/todos/:id")
	public Todo updateExistingTodo(@PathParam("id") Long id, @RequestBody Todo todo) {
		if (repository.findById(id).isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		todo.setId(id);
		return repository.save(todo);
	}

	@DeleteMapping("/todos/:id")
	public Todo deleteTodo(@PathParam("id") Long id) {
		Optional<Todo> optionalTodo = repository.findById(id);
		if (optionalTodo.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		Todo todo = optionalTodo.get();
		repository.delete(todo);
		return todo;
	}
}
