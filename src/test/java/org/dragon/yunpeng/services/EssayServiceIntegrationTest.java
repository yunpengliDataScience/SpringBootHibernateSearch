package org.dragon.yunpeng.services;

import java.util.List;

import org.dragon.yunpeng.entities.Essay;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EssayServiceIntegrationTest {

	@Autowired
	EssayService essayService;

	@Test
	public void testOracleTextSearch() {

		List<Essay> results = essayService.search("tiger");

		for (Essay essay : results) {
			System.out.println(essay);
		}
	}

	@BeforeEach
	public void saveEssays() {
		for (int i = 0; i < 5; i++) {
			Essay essay = new Essay();

			essay.setTitle("I am a tiger !" + i);
			essay.setAuthor("Cliff");
			essay.setContent("This is a test essay.");

			essayService.save(essay);
		}

		for (int i = 0; i < 5; i++) {
			Essay essay = new Essay();

			essay.setTitle("Test essay " + i);
			essay.setAuthor("Cliff");
			essay.setContent("This is an essay about tiger.");

			essayService.save(essay);
		}
	}
}
