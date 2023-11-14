package org.dragon.yunpeng.services;

import java.util.List;

import javax.persistence.EntityManager;

import org.dragon.yunpeng.entities.Book;
import org.dragon.yunpeng.repositories.BookRepository;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	EntityManager entityManager;

	@Transactional
	public void save(Book book) {
		bookRepository.save(book);
	}

	@Transactional(readOnly = true)  //Make test happy
	public List<Book> search(String term) {
		SearchSession searchSession = Search.session(entityManager);

		SearchResult<Book> result = searchSession.search(Book.class)

				.where(f -> f.match()

						.field("title")

						.matching(term))

				.fetchAll();

		long totalHitCount = result.total().hitCount();

		System.out.println("totalHitCount=" + totalHitCount);

		List<Book> hits = result.hits();

		return hits;
	}
}
