import com.rsone.java10.publisher_subscriber.NumberPublisher;
import com.rsone.java10.publisher_subscriber.PrintingSubscriber;

public class Main {

    public static void main(String[] args) {
        NumberPublisher numberPublisher= new NumberPublisher();
        PrintingSubscriber printingSubscriber = new PrintingSubscriber();

        numberPublisher.subscribe(printingSubscriber);
        numberPublisher.start();
    }
}
