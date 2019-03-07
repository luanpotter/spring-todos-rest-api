package com.packt.rest.todos;

import com.packt.rest.todos.todo.Todo;
import com.packt.rest.todos.todo.TodoApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodosApiApplicationTests {

	@Autowired
	private TodoApi todoApi;

	@Test
	public void testListBothInitialTodos() {
		List<Todo> todos = todoApi.listTodos();
		assertThat(todos.size()).isEqualTo(2);
	}

}
