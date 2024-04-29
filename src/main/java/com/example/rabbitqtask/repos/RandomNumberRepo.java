package com.example.rabbitqtask.repos;

import com.example.rabbitqtask.models.RandomNumberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RandomNumberRepo extends JpaRepository<RandomNumberEntity,Long> {
}
