package wsb.merito.pz.cw07.mongodb;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.*; // Synchroniczne
import com.mongodb.reactivestreams.client.*; // Reaktywne
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.CountDownLatch;

public class MongoExample {
    public static void main(String[] args) throws InterruptedException {
        // 🔹 Podejście SYNCHRONICZNE
        com.mongodb.client.MongoClient syncClient = com.mongodb.client.MongoClients.create("mongodb://localhost:27017");
        MongoDatabase syncDatabase = syncClient.getDatabase("sample_mflix");
        MongoCollection<Document> syncCollection = syncDatabase.getCollection("movies");

        System.out.println("🔹 Wyniki synchroniczne:");
        for (Document doc : syncCollection.find().limit(5)) {
            System.out.println("Film: " + doc.getString("title") + " (" + doc.getInteger("year") + ")");
        }
        syncClient.close();

        // 🔹 Podejście REAKTYWNE
        com.mongodb.reactivestreams.client.MongoClient reactiveClient = com.mongodb.reactivestreams.client.MongoClients.create("mongodb://localhost:27017");
        com.mongodb.reactivestreams.client.MongoDatabase reactiveDatabase = reactiveClient.getDatabase("sample_mflix");
        com.mongodb.reactivestreams.client.MongoCollection<Document> reactiveCollection = reactiveDatabase.getCollection("movies");

        System.out.println("🔹 Wyniki reaktywne:");
        CountDownLatch latch = new CountDownLatch(1); // Pomaga czekać na zakończenie operacji

        reactiveCollection.find()
                .limit(5)
                .subscribe(new PrintSubscriber(latch));
        latch.await(); // Czekamy na zakończenie operacji
    }
}
