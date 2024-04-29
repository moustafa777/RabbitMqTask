# RabbitMQTask

RabbitQTask is a Spring Boot application that demonstrates asynchronous communication using RabbitMQ. It consists of components for generating random numbers, sending them to a queue, and processing them asynchronously.

## Components

### NumberGeneratorScheduler

This component is responsible for generating random numbers at fixed intervals and sending them to a RabbitMQ queue.

- **Class**: `NumberGeneratorScheduler`
- **Scheduled Task**: Generates random numbers and sends them to the queue at a fixed interval.
- **Dependencies**:
    - `GenerateRandomNumberService`: Service for generating random numbers.
    - `RabbitTemplate`: RabbitMQ template for sending messages.
    - `Queue`: RabbitMQ queue for sending messages.

### NumberMultiplierListener

This component listens to the RabbitMQ queue for incoming messages, processes them, and saves the results.

- **Class**: `NumberMultiplierListener`
- **RabbitMQ Listener**: Listens to the queue for incoming messages and processes them.
- **Dependencies**:
    - `ResultService`: Service for saving the results.
    - `GenerateRandomNumberService`: Service for mapping JSON messages to `RandomNumberEntity`.

## Services

### GenerateRandomNumberService

This service generates random numbers and converts `RandomNumberEntity` objects to JSON and vice versa.

- **Class**: `GenerateRandomNumberService`
- **Methods**:
    - `generateRandomNumber()`: Generates a random number and saves it using `RandomNumberRepo`.
    - `mapToJson(RandomNumberEntity randomNumberEntity)`: Converts a `RandomNumberEntity` object to JSON string.
    - `mapFromJson(String message)`: Converts a JSON string to a `RandomNumberEntity` object.

### ResultService

This service processes random numbers and saves their results.

- **Class**: `ResultService`
- **Methods**:
    - `saveResult(RandomNumberEntity randomNumberEntity)`: Calculates the result of a random number and saves it using `ResultRepo`.

## Global Exception Handling

The `GlobalExceptionHandler` class handles exceptions globally for the REST controllers in the application.

## Usage

To run the RabbitQTask application using Docker Compose, follow these steps:

1. open a terminal window and navigate to the project directory.
2. Run the following command to run the application using Docker Compose by running the following command: ```docker-compose up```.

To run the RabbitQTask application locally, follow these steps:

1.install RabbitMQ on your local machine and start the RabbitMQ server on port 5672.
2.install MySQL on your local machine and create a database named `task` on port 3306.
3.run the RabbitQTask application.
