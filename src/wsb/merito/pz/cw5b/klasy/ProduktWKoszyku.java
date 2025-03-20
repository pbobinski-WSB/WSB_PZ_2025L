package wsb.merito.pz.cw5b.klasy;

import java.util.Objects;

public class ProduktWKoszyku extends Produkt{

    private int liczba;

    public ProduktWKoszyku(Produkt produkt, int liczba) {
        this(produkt.getNazwa(), produkt.getCena());
        this.liczba = liczba;
    }

    public ProduktWKoszyku(String nazwa, double cena) {
        super(nazwa, cena);
    }

    public int getLiczba() {
        return liczba;
    }

    public void setLiczba(int liczba) {
        this.liczba = liczba;
    }

    @Override
    public String toString() {
        return "ProduktWKoszyku{" +
                "liczba=" + liczba + "\n" +
                "\t" + super.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ProduktWKoszyku that)) return false;
        if (!super.equals(o)) return false;
        return getLiczba() == that.getLiczba();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getLiczba());
    }

    public double getWartosc(){
        return liczba * getCena();
    }
}
