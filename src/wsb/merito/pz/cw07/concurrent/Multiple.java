package wsb.merito.pz.cw07.concurrent;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Multiple {

    public static void main(String[] args) {

// Asynchroniczne przetwarzanie wielu zapytań HTTP jednocześnie

        List<String> urls = List.of(
                "https://jsonplaceholder.typicode.com/posts/1",
                "https://jsonplaceholder.typicode.com/posts/2",
                "https://jsonplaceholder.typicode.com/posts/3"
        );

        HttpClient client = HttpClient.newHttpClient();

        List<CompletableFuture<String>> futures = urls.stream()
                .map(url -> {
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(url))
                            .GET()
                            .build();
                    return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                            .thenApply(HttpResponse::body);
                })
                .toList();

        // Czekanie na wszystkie odpowiedzi i ich przetwarzanie
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> futures.forEach(future -> System.out.println(future.join())))
                .join();


    }
}

