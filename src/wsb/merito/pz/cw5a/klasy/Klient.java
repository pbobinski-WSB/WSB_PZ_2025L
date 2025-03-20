package wsb.merito.pz.cw5a.klasy;

import java.util.Objects;

public class Klient {

    private String name;

    private Koszykable koszyk;

    private double budzet;

    public Klient() {
    }

    public Klient(String name, double budzet) {
        this.name = name;
        this.koszyk = new Koszyk();
        this.budzet = budzet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudzet() {
        return budzet;
    }

    public void setBudzet(double budzet) {
        this.budzet = budzet;
    }

    public Koszykable getKoszyk() {
        return koszyk;
    }

    public void setKoszyk(Koszykable koszyk) {
        this.koszyk = koszyk;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "name='" + name + '\'' +
                ", koszyk=" + koszyk +
                ", budzet=" + budzet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Klient klient)) return false;
        return Double.compare(getBudzet(), klient.getBudzet()) == 0 && Objects.equals(getName(), klient.getName()) && Objects.equals(getKoszyk(), klient.getKoszyk());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getKoszyk(), getBudzet());
    }
}
