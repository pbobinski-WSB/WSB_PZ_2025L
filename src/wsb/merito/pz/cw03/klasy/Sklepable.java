package wsb.merito.pz.cw03.klasy;

import java.util.HashSet;

public interface Sklepable {

    void zatowaruj();

    void wpuscKlientow(HashSet<Klient> klienci);

    void zakupy();

    void obsluga();

}
