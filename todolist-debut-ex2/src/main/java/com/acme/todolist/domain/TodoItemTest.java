package com.acme.todolist.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.acme.todolist.domain.TodoItem;


class TodoItemTest {

	private String id = "a";
	private String content = "new content a";
	private String LATE = "[LATE!] ";
	
	@Test
	void TextTodoItemCreateNow() {
		Instant time = Instant.now();
		verifResult(time,content);
	}
	
	void verifResult(Instant time,String reponseAttendu) {
		TodoItem fakeItem = new TodoItem(id,time,content);
		String rep = fakeItem.finalContent();
		assertEquals(reponseAttendu,rep);
	}
	
	@Test
	void TextTodoItemCreateBefore24h() {
		int nb_heure_aleatoire = new Random().nextInt(24);
		Instant time = Instant.now().minus(nb_heure_aleatoire, ChronoUnit.HOURS);
		verifResult(time,content);
	}	
	@Test
	void TextTodoItemCreate24hAgo() {
		int nb_heure_aleatoire = 24;
		Instant time = Instant.now().minus(nb_heure_aleatoire, ChronoUnit.HOURS);
		verifResult(time,LATE+content);
	}
	@Test
	void TextTodoItemCreateAfter24h() {
		int nb_heure_aleatoire = new Random().nextInt(1000) + 25;
		Instant time = Instant.now().minus(nb_heure_aleatoire, ChronoUnit.HOURS);
		verifResult(time,LATE+content);
	}
	
}