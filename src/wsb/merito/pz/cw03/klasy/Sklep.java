package wsb.merito.pz.cw03.klasy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Sklep implements Sklepable{

    private static Sklep instance = null;

    public static Sklep getInstance() {
        if (instance == null) {
            instance = new Sklep();
        }
        return instance;
    }

    private Sklep () {}



    private final ArrayList<Produkt> produkty = new ArrayList<>();

    private HashSet<Klient> klienci = new HashSet<>();

    private final ArrayDeque<Klient> kolejka = new ArrayDeque<>();

    private double utarg = 0;

    @Override
    public void zatowaruj() {

        produkty.add(new Produkt("woda",3.4));
        produkty.add(new Produkt("chleb",2.4));
        produkty.add(new Produkt("zupa",9.7));
        produkty.add(new Produkt("sushi",36.8));
        produkty.add(new Produkt("szynka",8.1));

    }

    @Override
    public void wpuscKlientow(HashSet<Klient> klienci) {

        this.klienci = klienci;
    }

    @Override
    public void zakupy() {

        Random random = new Random();

        for (Klient klient : klienci) {

            for (int i = 0; i < 3; i++) {
                ProduktWkoszyku produktWkoszyku =
                        new ProduktWkoszyku(produkty.get(random.nextInt(produkty.size())),
                                1 + random.nextInt(6));
                try {
                    klient.getKoszyk().wloz(produktWkoszyku);
                } catch (PrzekroczonyLimitException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            kolejka.add(klient);
        }

    }

    @Override
    public void obsluga() {

        Klient klient;

        while ((klient = kolejka.poll()) != null) {

            System.out.println("Klient "+klient);

            ProduktWkoszyku produktWkoszyku;

            double kwota = 0;
            while ((produktWkoszyku = klient.getKoszyk().wyjmij()) != null) {

                kwota += produktWkoszyku.getCena() * produktWkoszyku.getLiczba();

            }
            utarg += kwota;
            System.out.println("płaci");
            System.out.println(kwota);
        }
        System.out.println("Sklep zarobił "+utarg);

    }


    @Override
    public String toString() {
        return "Sklep{\n" +
                "produkty=" + produkty +
                "\nklienci=" + klienci +
                "\nkolejka=" + kolejka +
                "\nutarg=" + utarg +
                '}';
    }
}
