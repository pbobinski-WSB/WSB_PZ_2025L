package wsb.merito.pz.cw07.concurrent;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Parallel {

    private static int counter = 0; // Zmienna współdzielona

    public static void main(String[] args) {

        List<Integer> numbers = IntStream.range(1, 100).boxed().toList();

        int sum = numbers.parallelStream()
                .reduce(0, Integer::sum);

        System.out.println("Suma (równolegle): " + sum);

        //UWAGA: Operacje na zmiennych współdzielonych mogą prowadzić do błędów!

        //Bezpieczne podejście (synchronizacja):
        numbers = IntStream.range(1, 100).boxed().toList();
        AtomicInteger atomicSum = new AtomicInteger(0);

        numbers.parallelStream().forEach(atomicSum::addAndGet);

        System.out.println("Bezpieczna suma: " + atomicSum.get());

        //Wyścig (race) - demonstracja
        numbers.parallelStream().forEach(n -> {
            counter += n; // Współdzielona zmienna
        });
        System.out.println("Wynik z możliwym wyścigiem: " + counter);

        AtomicInteger counter = new AtomicInteger(0);
        numbers.parallelStream().forEach(counter::addAndGet);
        System.out.println("Wynik bezpieczny: " + counter.get());

    }
}