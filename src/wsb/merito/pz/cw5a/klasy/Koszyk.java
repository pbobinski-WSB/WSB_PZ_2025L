package wsb.merito.pz.cw5a.klasy;

import java.util.Stack;

public class Koszyk implements Koszykable {

    private Klient owner;

    public Koszyk() {
        this.owner = owner;
        this.cart = new Stack<>();
    }

    Stack<ProduktWKoszyku> cart;

    private double cartValue() {
        double val = 0;
        for (ProduktWKoszyku pwk : cart) {
            val += pwk.getLiczba() * pwk.getCena();
        }
        return val;
    }

    @Override
    public void wloz(ProduktWKoszyku produktWKoszyku) throws ZaDrogo {
        if (produktWKoszyku.getLiczba() * produktWKoszyku.getCena() + cartValue() > owner.getBudzet()) {
            throw new ZaDrogo("Przekroczony budżet");
        } else {
            cart.push(produktWKoszyku);
        }
    }

    @Override
    public ProduktWKoszyku wyjmij() {
        if (cart.empty()) {
            return null;
        }
        return cart.pop();
    }
}
