package org.dragon.yunpeng.services;

import java.util.List;

import javax.persistence.EntityManager;

import org.dragon.yunpeng.entities.Essay;
import org.dragon.yunpeng.repositories.EssayRepository;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EssayService {
	@Autowired
	private EssayRepository essayRepository;

	@Autowired
	EntityManager entityManager;

	@Transactional
	public void save(Essay essay) {
		essayRepository.save(essay);
	}

	@Transactional(readOnly = true) // Make test happy
	public List<Essay> search(String term) {
		SearchSession searchSession = Search.session(entityManager);

		SearchResult<Essay> result = searchSession.search(Essay.class)
				.where(f -> f.match()
						.fields("title", "content")
						.matching(term))
				.fetchAll();

		long totalHitCount = result.total().hitCount();

		System.out.println("totalHitCount=" + totalHitCount);

		List<Essay> hits = result.hits();

		return hits;
	}
}
