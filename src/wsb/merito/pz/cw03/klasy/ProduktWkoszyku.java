package wsb.merito.pz.cw03.klasy;

public class ProduktWkoszyku extends Produkt{

    private final int liczba;

    public ProduktWkoszyku(Produkt produkt, int liczba) {
        super(produkt.getNazwa(), produkt.getCena());
        this.liczba = liczba;
    }

    public int getLiczba() {
        return liczba;
    }

    @Override
    public String toString() {
        return "ProduktWkoszyku{" +
                "liczba=" + liczba +
                "} "+super.toString();
    }
}
