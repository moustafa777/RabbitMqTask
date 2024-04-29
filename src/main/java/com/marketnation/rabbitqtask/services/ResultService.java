package com.marketnation.rabbitqtask.services;

import com.marketnation.rabbitqtask.models.RandomNumberEntity;
import com.marketnation.rabbitqtask.models.ResultEntity;
import com.marketnation.rabbitqtask.repos.ResultRepo;
import org.springframework.stereotype.Service;

@Service
public class ResultService {
    private final ResultRepo resultRepo;

    public ResultService(ResultRepo resultRepo) {
        this.resultRepo = resultRepo;
    }

    public void saveResult(RandomNumberEntity randomNumberEntity) {
        ResultEntity result = new ResultEntity();
        result.setId(randomNumberEntity.getId());
        result.setResult(randomNumberEntity.getRandomNumber()*2);
        resultRepo.save(result);
    }
}
