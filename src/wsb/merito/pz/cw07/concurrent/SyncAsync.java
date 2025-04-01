package wsb.merito.pz.cw07.concurrent;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

public class SyncAsync {

    public static void main(String[] args) throws IOException, InterruptedException {

        // Synchroniczne pobieranie danych (blokujące):

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        List<String> titles = Arrays.stream(response.body().split("\n"))
                .filter(line -> line.contains("title"))
                .map(line -> line.replaceAll("[\",]", "").trim())
                .toList();

        titles.forEach(System.out::println);


// Asynchroniczne pobieranie (bez blokowania):
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
                .GET()
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(body -> Arrays.stream(body.split("\n"))
                        .filter(line -> line.contains("title"))
                        .toList())
                .thenAccept(System.out::println)
                .join();


    }

}

