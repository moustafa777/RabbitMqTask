package com.marketnation.rabbitqtask.repos;

import com.marketnation.rabbitqtask.models.RandomNumberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RandomNumberRepo extends JpaRepository<RandomNumberEntity,Long> {
}
