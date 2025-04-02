package wsb.merito.pz.cw07.mongodb;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.bson.Document;
import java.util.concurrent.CountDownLatch;

public class PrintSubscriber implements Subscriber<Document> {
    private final CountDownLatch latch;

    public PrintSubscriber(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE); // Pobieramy wszystkie dostępne dane
    }

    @Override
    public void onNext(Document movie) {
        System.out.println("Film: " + movie.getString("title") + " (" + movie.getInteger("year") + ")");
    }

    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
        latch.countDown();
    }

    @Override
    public void onComplete() {
        System.out.println("Pobieranie zakończone.");
        latch.countDown();
    }
}

