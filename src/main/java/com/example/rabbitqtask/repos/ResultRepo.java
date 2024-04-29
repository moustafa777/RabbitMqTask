package com.example.rabbitqtask.repos;

import com.example.rabbitqtask.models.ResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepo extends JpaRepository<ResultEntity,Long> {
}
