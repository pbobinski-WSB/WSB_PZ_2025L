package wsb.merito.pz.cw07.concurrent;

import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreamDemo {
    public static void main(String[] args) {
        System.out.println("⏳ Start przetwarzania...");

        List<Integer> numbers = IntStream.range(1, 11).boxed().toList();

//        numbers.stream()
        numbers.parallelStream()
                .map(n -> processNumber(n))
                .forEach(result -> System.out.println("✅ Wynik: " + result));

        System.out.println("🏁 Koniec!");
    }

    private static int processNumber(int n) {
        String threadName = Thread.currentThread().getName();
        System.out.println("🔄 Przetwarzanie " + n + " w wątku: " + threadName);

        try {
            Thread.sleep(500); // Symulujemy dłuższą operację
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return n * 2;
    }
}
