package com.rsone.java10.publisher_subscriber;

public class PrintingSubscriber<T> extends SubscriberBase<T> {

    @Override
    public void onNext(Object item) {
        System.out.println(item);
        subscription.request(2);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("we are done");
    }
}
