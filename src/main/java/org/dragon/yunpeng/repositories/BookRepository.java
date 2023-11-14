package org.dragon.yunpeng.repositories;

import org.dragon.yunpeng.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
