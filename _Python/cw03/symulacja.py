
from klasy import *

def symulacja():
    print("Witaj w sklepie")
    sklep = Sklep()
    print(sklep)

    print("Zatowarowanie")
    sklep.zatowaruj()
    print(sklep)

    print("Tworzę klientów")
    klienci = {
        Klient("Adam", 5),
        Klient("Ewa", 150),
        Klient("Karol", 250),
        Klient("Zuza", 100),
        Klient("Anna", 150),
        Klient("Paweł", 500)
    }

    print("i wpuszczam do sklepu")
    sklep.wpusc_klientow(klienci)
    print(sklep)

    print("Zakupy:")
    for klient in klienci:
        try:
            klient.koszyk.dodaj_produkt(sklep.produkty[0], 1)
            print(f"{klient.imie} dodał do koszyka: {sklep.produkty[0].nazwa}")
        except ValueError as e:
            print(f"{klient.imie}: {e}")

if __name__ == "__main__":
    symulacja()
