package wsb.merito.pz.cw5b.symulacja;

import wsb.merito.pz.cw5b.klasy.Produkt;
import wsb.merito.pz.cw5b.klasy.ProduktWKoszyku;

public class Testy {

    public static void main(String[] args) {

        Produkt produkt1 = new Produkt("Mleko",2.5);
        Produkt produkt2 = new Produkt("Mlek",2.5);

        System.out.println(produkt1);

        System.out.println(produkt1 == produkt2);
        System.out.println(produkt1.equals(produkt2));

        System.out.println(produkt1.hashCode());
        System.out.println(produkt2.hashCode());

        ProduktWKoszyku produktWKoszyku = new ProduktWKoszyku(produkt1,4);

        System.out.println(produktWKoszyku);



    }

}
