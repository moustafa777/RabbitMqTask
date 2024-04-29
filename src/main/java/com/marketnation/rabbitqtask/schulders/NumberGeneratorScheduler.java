package com.marketnation.rabbitqtask.schulders;

import com.marketnation.rabbitqtask.models.RandomNumberEntity;
import com.marketnation.rabbitqtask.services.GenerateRandomNumberService;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



import java.util.logging.Logger;

@Component
public class NumberGeneratorScheduler {
    private final GenerateRandomNumberService generateRandomNumberService;
    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;
    private final Logger logger = Logger.getLogger(GenerateRandomNumberService.class.getName());

    public NumberGeneratorScheduler(GenerateRandomNumberService generateRandomNumberService, RabbitTemplate rabbitTemplate, Queue queue){
        this.generateRandomNumberService = generateRandomNumberService;
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;

    }
    @Scheduled(fixedDelayString = "${scheduler.interval}")
    public void generateAndSendRandomNumberToQueue() throws JsonProcessingException {
        logger.info("Generating random number and sending to queue ...");
        RandomNumberEntity randomNumber = generateRandomNumberService.generateRandomNumber();
        String randomNumberJson = generateRandomNumberService.mapToJson(randomNumber);
        logger.info("Random number generated: " + randomNumberJson);
        rabbitTemplate.convertAndSend(queue.getName(), randomNumberJson);
        logger.info("Random number sent to queue");
    }
}
