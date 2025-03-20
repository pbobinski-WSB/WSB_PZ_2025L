package wsb.merito.pz.cw5b.symulacja;

import wsb.merito.pz.cw5b.klasy.Klient;
import wsb.merito.pz.cw5b.klasy.Produkt;
import wsb.merito.pz.cw5b.klasy.Sklep;

import java.util.ArrayList;
import java.util.List;

public class Zakupy {

    public static void main(String[] args) {

        System.out.println("Zakupy - start");

        System.out.println("Utwórz sklep.");

        //Sklep sklep = new Sklep();
        Sklep sklep = Sklep.getInstance();

        System.out.println("Utwórz listę produktów i zatowaruj sklep.");

        List<Produkt> produkts = new ArrayList<>();
        sklep.zatowaruj(produkts);

        System.out.println("Utwórz listę klientów i wpuść ich do sklepu");

        List<Klient> klients = new ArrayList<>();
        sklep.wpuscKlientow(klients);

        System.out.println("Zasymuluj zakupy klientów w sklepie, kupują i dodają się do kolejki w sklepie.");
        System.out.println("Zasymuluj obsługę w kasie, klienci w kolejności z kolejki.");

        sklep.kupowanie();

        System.out.println("Podsumuj sesję zakupów, wyświetl raport.");

        System.out.println(sklep.raportuj());
    }

}
