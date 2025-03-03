package wsb.merito.pz.cw03.klasy;

public class Klient {

    private final String name;

    private final Koszyk koszyk;

    public Koszyk getKoszyk() {
        return koszyk;
    }

    public Klient(String name, double limit) {
        this.name = name;
        this.koszyk = new Koszyk(limit);
    }

    @Override
    public String toString() {
        return "Klient{" +
                "name='" + name + '\'' +
                ", koszyk=" + koszyk +
                '}';
    }
}
