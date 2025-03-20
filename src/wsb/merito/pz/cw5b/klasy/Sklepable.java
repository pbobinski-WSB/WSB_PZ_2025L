package wsb.merito.pz.cw5b.klasy;

import java.util.List;

public interface Sklepable {

    /**
     * TODO: nieskończona dostępność produktów
     *
     */
    public void zatowaruj(List<Produkt> produkts);

    public  void wpuscKlientow(List<Klient> klients);

    public  void kupowanie();

    public String raportuj();

}
