package com.example.rabbitqtask.listeners;

import com.example.rabbitqtask.models.RandomNumberEntity;
import com.example.rabbitqtask.services.GenerateRandomNumberService;
import com.example.rabbitqtask.services.ResultService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


import java.util.logging.Logger;

@Component
public class NumberMultiplierListener {
    private final ResultService resultService;
    private final GenerateRandomNumberService generateRandomNumberService;
    private final Logger logger = Logger.getLogger(GenerateRandomNumberService.class.getName());
    public NumberMultiplierListener(ResultService resultService, GenerateRandomNumberService generateRandomNumberService) {
        this.resultService = resultService;
        this.generateRandomNumberService = generateRandomNumberService;
    }
    @RabbitListener(queues =  "${queue.name}")
    public void receiveMessage(String message) {
        logger.info("Received message: " + message);
        RandomNumberEntity randomNumberEntity = generateRandomNumberService.mapFromJson(message);
        logger.info("Random number entity: " + randomNumberEntity);
        resultService.saveResult(randomNumberEntity);
        logger.info("Result saved");
    }

}
