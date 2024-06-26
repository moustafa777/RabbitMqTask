package com.marketnation.rabbitqtask.services;

import com.marketnation.rabbitqtask.models.RandomNumberEntity;
import com.marketnation.rabbitqtask.repos.RandomNumberRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class GenerateRandomNumberService {

    private final RandomNumberRepo randomNumberRepo;
    public GenerateRandomNumberService(RandomNumberRepo randomNumberRepo) {
        this.randomNumberRepo = randomNumberRepo;
    }

    public RandomNumberEntity generateRandomNumber() {
        RandomNumberEntity randomNumberEntity = new RandomNumberEntity();
        randomNumberEntity.setRandomNumber((int) (Math.random() * 1000));
        return randomNumberRepo.save(randomNumberEntity);
    }
    public String mapToJson(RandomNumberEntity randomNumberEntity) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(randomNumberEntity);
    }

    public RandomNumberEntity mapFromJson(String message) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        RandomNumberEntity randomNumberEntity = null;
        try {
            randomNumberEntity = mapper.readValue(message, RandomNumberEntity.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new Exception(e);
    }
        return randomNumberEntity;
    }
}
