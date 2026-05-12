package com.bookmarket.catalogservice.web;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import com.bookmarket.catalogservice.domain.Book;

@JsonTest
public class BookJsonTests {
    @Autowired
    private JacksonTester<Book> json;

    @Test
    void testSerialize() throws Exception {
        var book = new Book("123", "Title", "Author", 9.99);
        var jsonContent = json.write(book);
        assertThat(jsonContent).extractingJsonPathStringValue("@.isbn").isEqualTo(book.isbn());
        assertThat(jsonContent).extractingJsonPathStringValue("@.title").isEqualTo(book.title());
        assertThat(jsonContent).extractingJsonPathStringValue("@.author").isEqualTo(book.author());
        assertThat(jsonContent).extractingJsonPathStringValue("@.price").isEqualTo(book.price());
    }

    @Test
    void testDeserialize() throws Exception {
        var content = """
                        {
                    "isbn": "123",
                    "title": "Title",
                    "author": "Author",
                    "price": 9.99
                }
                        """;
        assertThat(json.parse(content)).usingRecursiveComparison().isEqualTo(new Book("123", "Title", "Author", 9.99));
    }
}
