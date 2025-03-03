package wsb.merito.pz.cw03.symulacja;

import wsb.merito.pz.cw03.klasy.Klient;
import wsb.merito.pz.cw03.klasy.Sklep;

import java.util.HashSet;

public class Symulacja {

    public static void main(String[] args) {
        System.out.println("Witaj w sklepie");

        Sklep sklep = Sklep.getInstance();
        System.out.println(sklep);
        System.out.println("Zatowarowanie");
        sklep.zatowaruj();
        System.out.println(sklep);
        System.out.println("Tworzę klientów");

        HashSet<Klient> klients = new HashSet<>();
        klients.add(new Klient("Adam",5));
        klients.add(new Klient("Ewa",150));
        klients.add(new Klient("Karol",250));
        klients.add(new Klient("Zuza",100));
        klients.add(new Klient("Anna",150));
        klients.add(new Klient("Paweł",500));
        System.out.println("i wpuszczam do sklepu");
        sklep.wpuscKlientow(klients);
        System.out.println(sklep);
        System.out.println("Zakupy");
        sklep.zakupy();
        System.out.println(sklep);
        System.out.println("Obsługa");
        sklep.obsluga();
        System.out.println("Koniec");
        System.out.println(sklep);

    }
}
