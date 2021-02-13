package com.gmarchiprojects.messagingrabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private final RabbitTemplate rabbitTemplate;
    @Autowired
    private final Receiver receiver;

    public Runner (Receiver receiver, RabbitTemplate rabbitTemplate){
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception{
        System.out.println("Sending Message...");

        rabbitTemplate.convertAndSend(MessagingRabbitmqApplication.topExchangeName,"foo.bar.baz", "Hello from Rabbit");
        receiver.getLanch().await(10000, TimeUnit.MILLISECONDS);
    }


}


