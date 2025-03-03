package wsb.merito.pz.cw03.klasy;

public interface Koszykable {

    void wloz(ProduktWkoszyku produktWkoszyku) throws PrzekroczonyLimitException;

    ProduktWkoszyku wyjmij();

}
