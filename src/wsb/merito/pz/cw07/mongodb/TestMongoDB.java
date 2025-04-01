package wsb.merito.pz.cw07.mongodb;


import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


public class TestMongoDB {

    public static void main(String[] args) {

        System.out.println("Hello from mongoDB");

        ConnectionString connectionString = new ConnectionString("mongodb+srv://");
        MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(connectionString).build();
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            List<Document> dbs = mongoClient.listDatabases().into(new ArrayList<>());
            System.out.println("-----bazy danych ------");
            System.out.println(dbs);
            System.out.println("----- bazy danych ------");
            dbs.forEach(d -> System.out.println(d.toJson()));

            MongoDatabase database = mongoClient.getDatabase("sample_mflix");

            MongoCollection<Document> theatersCollection = database.getCollection("theaters");

            List<Document> theatersList = new ArrayList<>();
            try (MongoCursor<Document> cursor = theatersCollection.find().iterator()) {
                while (cursor.hasNext()) {
                    theatersList.add(cursor.next());
                }
            }

            System.out.println("----- kina z CA -----");

            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("location.address.state", "CA");
            theatersCollection.find(whereQuery)
                    .limit(15)
                    .map(doc -> doc.get("location", Document.class))
                    .map(location -> location.get("address", Document.class))
                    .map(Document::toJson)
                    .forEach((Block<? super String>) System.out::println);

            List<String> cities = theatersList.stream()
                    .limit(15)
                    .map(doc -> doc.get("location", Document.class))
                    .map(location -> location.get("address", Document.class))
                    .map(address -> (address.getString("state")) + " " + address.getString("city"))
                    .collect(Collectors.toList());
            cities.forEach(System.out::println);

            System.out.println("----- filmy -----");

            MongoCollection<Document> movies = database.getCollection("movies");
            try (MongoCursor<Document> cursor = movies.find().limit(10).iterator()) {
                cursor.forEachRemaining(movie -> {
                    System.out.println("Film: " + movie.getString("title") + " (" + movie.getInteger("year") + ")");
                });
            }

            System.out.println("----- filmy i strumienie -----");
            try (MongoCursor<Document> cursor = movies.find().iterator()) {
                StreamSupport.stream(Spliterators.spliteratorUnknownSize(cursor, Spliterator.ORDERED), false)
                        .filter(movie -> {
                            Object yearObj = movie.get("year");
                            if (yearObj instanceof Integer year) {
                                return year > 2000;
                            }
                            return false;
                        })
                        .filter(m -> ((Document)m.get("awards")).getInteger("wins") > 200)
                        .map(movie -> "Film: " + movie.getString("title") + " (" + movie.get("year") + ")" + " [" + movie.get("awards")+ "]")
                        .forEach(System.out::println);
            }


        }
    }
}
