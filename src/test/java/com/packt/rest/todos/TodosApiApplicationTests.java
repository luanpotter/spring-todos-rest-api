package xyz.luan.rest.todos;

import xyz.luan.rest.todos.todo.Todo;
import xyz.luan.rest.todos.todo.TodoApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class TodosApiApplicationTests {

	@Autowired
	private TodoApi todoApi;

	@Test
	public void testListBothInitialTodos() {
		List<Todo> todos = todoApi.listTodos();
		assertThat(todos.size()).isEqualTo(2);
	}

	@Test
	public void testCreateAndThenListTodos() {
		todoApi.createNewTodo(new Todo("hello!"));
		assertThat(todoApi.listTodos().size()).isEqualTo(3);
		Todo newTodo = todoApi.findTodo(3L);
		assertThat(newTodo.getText()).isEqualTo("hello!");
	}

	@Test
	public void testDeleteTodo() {
		Todo deletedTodo = todoApi.deleteTodo(2L);
		assertThat(todoApi.listTodos().size()).isEqualTo(1);

		Todo todo = todoApi.findTodo(1L);
		assertThat(deletedTodo.getText()).isNotEqualTo(todo.getText());
	}

	@Test
	public void testUpdateTodo() {
		Todo todo = new Todo("custom todo : 1");
		todoApi.createNewTodoWithId(3L, todo);
		assertThat(todoApi.findTodo(3L).getText()).isEqualTo("custom todo : 1");

		todo.setText("custom todo : 2");
		todoApi.updateExistingTodo(3L, todo);
		assertThat(todoApi.findTodo(3L).getText()).isEqualTo("custom todo : 2");
	}
}
