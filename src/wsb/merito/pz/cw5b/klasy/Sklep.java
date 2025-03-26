package wsb.merito.pz.cw5b.klasy;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.stream.Collectors;

public class Sklep implements Sklepable{

    //TODO: przejść na enum
    private static Sklep instance = null;

    private Sklep() {
    }

    public static Sklep getInstance() {
        if (instance == null) {
            instance = new Sklep();
        }
        return instance;
    }

    private double utarg = 0.0;

    private Queue<Klient> kolejka = new ArrayDeque<>();


    List<Produkt> produkts;
    List<Klient> klients;

    public List<Produkt> getProdukts() {
        return produkts;
    }

    public List<Klient> getKlients() {
        return klients;
    }

    @Override
    public void zatowaruj(List<Produkt> produkts) {
        this.produkts = produkts;
    }

    @Override
    public void wpuscKlientow(List<Klient> klients) {
        this.klients = klients;
    }

    @Override
    public void kupowanie() {
            // Dla każdego klienta
        for (Klient klient : klients) {
            int maxProd = produkts.size();
            Random random = new Random();
            int liczbaProdDoKupienia = random.nextInt(maxProd);
            // Dla wybranych produktów
            for (int i=0; i<liczbaProdDoKupienia; i++) {
                int index = random.nextInt(maxProd);
                Produkt produkt = produkts.get(index);
                int ileProduktu = random.nextInt(3)+1;
                ProduktWKoszyku produktWKoszyku = new ProduktWKoszyku(produkt,ileProduktu);
                try {
                    klient.getKoszyk().wloz(produktWKoszyku);
                } catch (ZaDrogo ex) {
                    System.out.println("Przekroczono budżet "+ex);
                }
            }
            System.out.println(klient);
            kolejka.add(klient);
            System.out.println("Klienci w kolejce " + kolejka.size());
        }
    }

    @Override
    public String raportuj() {
        return "Sklep zarobił "+ utarg;
    }

    record NameCartCount(String name, int cartCount) {
        @Override
        public String toString() {
            return "(" + name + "," + cartCount +")";
        }
    }

    public void platnosc() {
        // Obsługa kolejki w kasie
        System.out.println("Kolejka "+kolejka.stream().map(k -> new NameCartCount(k.getNazwa(), k.getKoszyk().getCartCount())).toList());
        Klient klient = null;
        while ((klient = kolejka.poll()) != null) {

            System.out.println("Obsługiwany klient Klient "+klient);

            ProduktWKoszyku produktWkoszyku = null;

            double kwota = 0;
            while ((produktWkoszyku = klient.getKoszyk().wyjmij()) != null) {

                kwota += produktWkoszyku.getCena() * produktWkoszyku.getLiczba();

            }
            utarg += kwota;
            System.out.println("Zapłacił " + kwota);
            System.out.println("Kolejka "+kolejka.stream().map(k -> k.getNazwa()).collect(Collectors.toList()));
        }

    }

}
