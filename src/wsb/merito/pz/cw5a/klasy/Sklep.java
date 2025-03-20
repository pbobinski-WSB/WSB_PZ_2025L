package wsb.merito.pz.cw5a.klasy;

import java.util.List;
import java.util.Random;

public class Sklep implements Sklepable {

    private static Sklep instance = null;

    private Sklep() {
    }

    public static Sklep getInstance() {
        if (instance == null) {
            instance = new Sklep();
        }
        return instance;
    }

    private List<Produkt> produkts;
    private List<Klient> klients;

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
            int liczbaProd = random.nextInt(maxProd);
            for (int i=0; i<liczbaProd; i++) {
                int index = random.nextInt(maxProd);
                Produkt produkt = produkts.get(index);
                ProduktWKoszyku produktWKoszyku = new ProduktWKoszyku(produkt,random.nextInt(3));
                //TODO tu kończę
            }

        }
    }

    @Override
    public void platnos() {

    }

    @Override
    public String raportowanie() {
        return "";
    }
}
