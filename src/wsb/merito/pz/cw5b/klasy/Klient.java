package wsb.merito.pz.cw5b.klasy;

import java.util.Objects;

public class Klient {

    private String nazwa;

    private double budzet;

    private Koszyk koszyk;

    public Klient(String nazwa, double budzet) {
        this.nazwa = nazwa;
        this.budzet = budzet;
        koszyk = new Koszyk();
        koszyk.setBudzet(budzet);
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getBudzet() {
        return budzet;
    }

    public void setBudzet(double budzet) {
        this.budzet = budzet;
    }

    public Koszyk getKoszyk() {
        return koszyk;
    }

    public void setKoszyk(Koszyk koszyk) {
        this.koszyk = koszyk;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "nazwa='" + nazwa + '\'' +
                ", budzet=" + budzet +
                ", koszyk=" + koszyk +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Klient klient)) return false;
        return Double.compare(getBudzet(), klient.getBudzet()) == 0 && Objects.equals(getNazwa(), klient.getNazwa()) && Objects.equals(getKoszyk(), klient.getKoszyk());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNazwa(), getBudzet(), getKoszyk());
    }
}
