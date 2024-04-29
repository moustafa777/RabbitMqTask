package com.marketnation.rabbitqtask;

import com.marketnation.rabbitqtask.models.RandomNumberEntity;
import com.marketnation.rabbitqtask.schulders.NumberGeneratorScheduler;
import com.marketnation.rabbitqtask.services.GenerateRandomNumberService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.anyString;


@SpringBootTest
class RabbitQTaskApplicationTests {
    @Mock
    private GenerateRandomNumberService generateRandomNumberService;

    @Mock
    private RabbitTemplate rabbitTemplate;

    private NumberGeneratorScheduler scheduler;

    @Mock
    private Queue queue;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        scheduler = new NumberGeneratorScheduler(generateRandomNumberService, rabbitTemplate, queue);
    }

    @Test
    public void testGenerateAndSendRandomNumberToQueue() throws JsonProcessingException {
        RandomNumberEntity randomNumberEntity = new RandomNumberEntity(); // Create a sample random number entity
        when(generateRandomNumberService.generateRandomNumber()).thenReturn(randomNumberEntity);
        when(generateRandomNumberService.mapToJson(randomNumberEntity)).thenReturn("randomNumberJson");
when(queue.getName()).thenReturn("randomNumberQueue");
        scheduler.generateAndSendRandomNumberToQueue();

        verify(generateRandomNumberService, times(1)).generateRandomNumber();
        verify(generateRandomNumberService, times(1)).mapToJson(randomNumberEntity);
        verify(rabbitTemplate, times(1)).convertAndSend(eq("randomNumberQueue"), anyString());
    }
}
