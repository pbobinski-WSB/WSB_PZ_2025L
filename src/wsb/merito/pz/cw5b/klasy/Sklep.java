package wsb.merito.pz.cw5b.klasy;

import java.util.List;

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

    List<Produkt> produkts;
    List<Klient> klients;

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
        //TODO
    }

    @Override
    public String raportuj() {
        return "";
    }
}
