package wsb.merito.pz.cw03.klasy;

import java.util.Stack;

public class Koszyk implements Koszykable{

    private final Stack<ProduktWkoszyku> koszyk = new Stack<>();

    private final double limit;

    public Koszyk(double limit) {
        this.limit = limit;
    }

    @Override
    public void wloz(ProduktWkoszyku produktWkoszyku) throws PrzekroczonyLimitException {
        if (getWartosc() + produktWkoszyku.getCena() * produktWkoszyku.getLiczba() > limit) {
            throw new PrzekroczonyLimitException("Przekroczono limit o "+ (getWartosc() + produktWkoszyku.getCena() * produktWkoszyku.getLiczba() - limit));
        } else {
            koszyk.push(produktWkoszyku);
        }
    }

    private double getWartosc() {
        double wartosc = 0;
        for (ProduktWkoszyku p : koszyk) {
            wartosc += p.getCena() * p.getLiczba();
        }
        return wartosc;
    }

    @Override
    public ProduktWkoszyku wyjmij() {
        if (koszyk.empty()) {
            return null;
        } else {
            return koszyk.pop();
        }

    }

    @Override
    public String toString() {
        return "Koszyk{" +
                "koszyk=" + koszyk +
                ", limit=" + limit +
                '}';
    }
}
