package com.gmarchiprojects.messagingrabbitmq;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {

    public CountDownLatch lanch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        lanch.countDown();
    }

    public CountDownLatch getLanch(){
        return lanch;
    }


}
