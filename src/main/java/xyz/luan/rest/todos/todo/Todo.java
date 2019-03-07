package xyz.luan.rest.todos.todo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Todo {

	@Id
	@GeneratedValue
	private Long id;

	private String text;

	public Todo(String text) {
		this.text = text;
	}
}
