package wsb.merito.pz.cw5a.klasy;

import java.util.List;

public interface Sklepable {

    /**
     *
     * Zakładamy, nieskończoną liczbę produktów w sklepie.
     * TODO: liczba sztuk oraz dara ważności.
     */
    public void zatowaruj(List<Produkt> produkts);

    public void wpuscKlientow(List<Klient> klients);

    public void kupowanie();

    public void platnos();

    public String raportowanie();
}
