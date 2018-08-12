package com.rsone.java10.publisher_subscriber;

import java.util.concurrent.Flow;

/**
 * This class handles the subscription so that only one subscriber will subscribe to our producer
 * @param <T>
 */
public abstract class SubscriberBase<T> implements Flow.Subscriber {

    protected Flow.Subscription subscription;


    @Override
    public void onSubscribe(Flow.Subscription incomingSubscription) {
        if(this.subscription==null){
            this.subscription = incomingSubscription;
            subscription.request(2);
        }else {
            // cancel the incoming subscription cause we had already an active subscription
            incomingSubscription.cancel();
        }
    }
}
