package wsb.merito.pz.cw5a.klasy;

import java.util.Objects;

public class Produkt {

    private String nazwa;

    private double cena;

    public Produkt() {
    }

    public Produkt(String nazwa, double cena) {
        this.nazwa = nazwa;
        this.cena = cena;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "nazwa='" + nazwa +
                ", cena=" + cena +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Produkt produkt)) return false;
        return Double.compare(getCena(), produkt.getCena()) == 0 && Objects.equals(getNazwa(), produkt.getNazwa());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNazwa(), getCena());
    }
}
