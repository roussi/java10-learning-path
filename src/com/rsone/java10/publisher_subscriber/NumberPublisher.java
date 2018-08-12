package com.rsone.java10.publisher_subscriber;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.stream.IntStream;

public class NumberPublisher implements Flow.Publisher<Integer> {

    private SubmissionPublisher submissionPublisher =  new SubmissionPublisher();
    
    @Override
    public void subscribe(Flow.Subscriber<? super Integer> subscriber) {
        submissionPublisher.subscribe(subscriber);
    }
    
    public void start(){
        IntStream.iterate(1, i-> i+1).forEach(this::submitelements);
    }

    private void submitelements(int e) {
        submissionPublisher.submit(e);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            throw new RuntimeException(e1);
        }
    }
}
