package wsb.merito.pz.cw07.catapi;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.IntStream;

public class CatSync {

    private static final String CAT_API_URL = "https://api.thecatapi.com/v1/images/search";

    public static void main(String[] args) {

                HttpClient client = HttpClient.newHttpClient();

                List<String> catImages = IntStream.range(0, 5)  // Pobieramy 5 obrazków
                        .mapToObj(i -> fetchCatImage(client))  // Wysyłamy żądanie dla każdego indeksu
                        .toList();

                System.out.println("Koty pobrane synchronicznie:");
                catImages.forEach(System.out::println);
            }

            private static String fetchCatImage(HttpClient client) {
                try {
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(CAT_API_URL))
                            .GET()
                            .build();

                    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                    // Prosta ekstrakcja URL-a z JSON-a (bez użycia bibliotek JSON)
                    return response.body().split("\"url\":\"")[1].split("\"")[0];

                } catch (Exception e) {
                    e.printStackTrace();
                    return "Błąd pobierania";
                }
            }
        }

