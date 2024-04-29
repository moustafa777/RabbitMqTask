package com.marketnation.rabbitqtask.repos;

import com.marketnation.rabbitqtask.models.ResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepo extends JpaRepository<ResultEntity,Long> {
}
