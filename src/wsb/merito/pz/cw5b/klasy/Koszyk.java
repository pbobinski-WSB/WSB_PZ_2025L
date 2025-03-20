package wsb.merito.pz.cw5b.klasy;

import java.util.Stack;

public class Koszyk implements Koszykable{

    private double budzet;

    private Stack<ProduktWKoszyku> cart;

    public Koszyk() {
        cart = new Stack<>();
    }

    public double getBudzet() {
        return budzet;
    }

    public void setBudzet(double budzet) {
        this.budzet = budzet;
    }

    private double wartosc() {
        double val = 0;
        for (ProduktWKoszyku produktWKoszyku : cart) {
            //val += produktWKoszyku.getCena() * produktWKoszyku.getLiczba();
            val += produktWKoszyku.getWartosc();
        }
        return val;
    }

    @Override
    public void wloz(ProduktWKoszyku produktWKoszyku) throws ZaDrogo {
        if (wartosc() + produktWKoszyku.getWartosc() > budzet) {
            throw new ZaDrogo("Kwota zbyt wysok");
        }
        cart.push(produktWKoszyku);
    }

    @Override
    public ProduktWKoszyku wyjmij() {
        if (cart.empty()) {
            return null;
        }
        return cart.pop();
    }
}
