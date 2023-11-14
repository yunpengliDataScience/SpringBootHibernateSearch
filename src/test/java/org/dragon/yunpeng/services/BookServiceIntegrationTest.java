package org.dragon.yunpeng.services;

import java.util.List;

import org.dragon.yunpeng.entities.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class BookServiceIntegrationTest {

	@Autowired
	BookService bookService;

	@Test
	public void testOracleTextSearch() {

		// saveBooks();

		List<Book> results = bookService.search("tiger");

		for (Book book : results) {
			System.out.println(book);
		}
	}

	@BeforeEach
	public void saveBooks() {
		for (int i = 0; i < 10; i++) {
			Book book = new Book();

			book.setTitle("I am a tiger !" + i);

			bookService.save(book);
		}
	}

//	@Test
//	public void testSave() {
//		Book book=new Book();
//		
//		//book.setId(1l);
//		book.setTitle("title");
//		
//		bookService.save(book);
//	}

}
