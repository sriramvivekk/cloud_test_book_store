package com.bookmarket.catalogservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.bookmarket.catalogservice.domain.Book;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CatalogServiceApplicationTests {
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void whenPostRequestBookCreated() {
		var expectedBook = new Book("123", "Title", "Author", 9.99);

		webTestClient.post().uri("/books").bodyValue(expectedBook).exchange().expectStatus().isCreated()
				.expectBody(Book.class).value(actualBook -> {
					assertThat(actualBook).isNotNull();
					assertThat(actualBook.isbn()).isEqualTo(expectedBook.isbn());
				});
	}

}
