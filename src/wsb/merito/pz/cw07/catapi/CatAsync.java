package wsb.merito.pz.cw07.catapi;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;


public class CatAsync {

    private static final String CAT_API_URL = "https://api.thecatapi.com/v1/images/search";

    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();

        // Tworzymy listę 5 asynchronicznych zapytań
        List<CompletableFuture<String>> futures = IntStream.range(0, 5)
                .mapToObj(i -> fetchCatImageAsync(client))
                .toList();

        // Czekamy na wszystkie odpowiedzi i wypisujemy wyniki
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    System.out.println("Koty pobrane asynchronicznie:");
                    futures.forEach(f -> System.out.println(f.join()));
                })
                .join();  // Czekamy na zakończenie wszystkich operacji
    }

    private static CompletableFuture<String> fetchCatImageAsync(HttpClient client) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(CAT_API_URL))
                .GET()
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(body -> body.split("\"url\":\"")[1].split("\"")[0])  // Ekstrakcja URL-a
                .exceptionally(e -> "Błąd pobierania: " + e.getMessage());
    }

}

