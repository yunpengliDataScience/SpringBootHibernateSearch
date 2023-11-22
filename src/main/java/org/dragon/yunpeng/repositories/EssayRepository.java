package org.dragon.yunpeng.repositories;

import org.dragon.yunpeng.entities.Essay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EssayRepository extends JpaRepository<Essay, Long>, JpaSpecificationExecutor<Essay> {

}
