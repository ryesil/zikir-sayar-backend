package com.fikir.zikirsayar.repository;

import com.fikir.zikirsayar.entity.ZikirEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface ZikirRepository extends JpaRepository<ZikirEntity,Long> {

}
