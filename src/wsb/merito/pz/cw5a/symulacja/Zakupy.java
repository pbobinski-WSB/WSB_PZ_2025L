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
        produkts.add(new Produkt("Mleko",3.5));
        produkts.add(new Produkt("Chleb",2.8));
        produkts.add(new Produkt("Ser",5.2));
        produkts.add(new Produkt("Mleko2",4.5));
        produkts.add(new Produkt("Chleb2",3.8));
        produkts.add(new Produkt("Ser2",6.2));
        produkts.add(new Produkt("Mleko3",5.5));
        produkts.add(new Produkt("Chleb3",4.8));
        produkts.add(new Produkt("Ser3",7.2));
        sklep.zatowaruj(produkts);
        System.out.println("Towary w sklepie");
        System.out.println(sklep.getProdukts());
        System.out.println("Utwórz listę klientów i wpuść ich do sklepu.");

        List<Klient> klients = new ArrayList<>();
        klients.add(new Klient("Adam",20));
        klients.add(new Klient("Ewa",30));
        klients.add(new Klient("Jan",40));
        klients.add(new Klient("Anna",50));
        klients.add(new Klient("Cezary",60));

        sklep.wpuscKlientow(klients);
        System.out.println("Klienci w sklepie");
        System.out.println(sklep.getKlients());

        System.out.println("Zasymuluj zakupy klientów w sklepie, kupują i dodają się do kolejki w sklepie.");

        sklep.kupowanie();

        System.out.println("Zasymuluj obsługę w kasie, klienci w kolejności z kolejki.");

        sklep.platnos();

        System.out.println("Podsumuj sesję zakupów, wyświetl raport.");

        System.out.println(sklep.raportowanie());

    }

}
