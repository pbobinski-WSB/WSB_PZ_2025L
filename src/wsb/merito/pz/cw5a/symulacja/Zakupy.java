package wsb.merito.pz.cw5a.symulacja;

import wsb.merito.pz.cw5a.klasy.Klient;
import wsb.merito.pz.cw5a.klasy.Produkt;
import wsb.merito.pz.cw5a.klasy.Sklep;

import java.util.ArrayList;
import java.util.List;

public class Zakupy {

    public static void main(String[] args) {

        System.out.println("Zakupy - start");

        System.out.println("Utwórz sklep.");

        // bo singleton Sklep sklep = new Sklep();
        Sklep sklep = Sklep.getInstance();

        System.out.println("Utwórz listę produktów i zatowaruj sklep.");

        List<Produkt> produkts = new ArrayList<>();
        produkts.add(new Produkt());
        sklep.zatowaruj(produkts);

        System.out.println("Utwórz listę klientów i wpuść ich do sklepu.");

        List<Klient> klients = new ArrayList<>();
        klients.add(new Klient());
        sklep.wpuscKlientow(klients);

        System.out.println("Zasymuluj zakupy klientów w sklepie, kupują i dodają się do kolejki w sklepie.");

        sklep.kupowanie();

        System.out.println("Zasymuluj obsługę w kasie, klienci w kolejności z kolejki.");

        sklep.platnos();

        System.out.println("Podsumuj sesję zakupów, wyświetl raport.");

        System.out.println(sklep.raportowanie());

    }

}
