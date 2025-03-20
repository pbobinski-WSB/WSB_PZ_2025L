Napisz program symulujący ~~kupowanie~~ produktów w **sklepie**. Luźny opis scenariusza:
W sklepie są **produkty**, 
**klienci** ~~wchodzą~~ do sklepu, 
~~wkładają~~ produkty do **koszyka**, 
ustawiają się w **kolejce** do _kasy_, 
~~płacą~~ za _zakupy_,
każdy klient ma określony _budżet_ na zakupy, którego nie może przekroczyć,
po zakupach sklep ~~przedstawia~~ _raport_ z kasy.

Zdefiniuj klasy:
**Produkt** – produkt w sklepie: pola: nazwa, cena
**ProduktWKoszyku** – rozszerza Produkt, dodatkowe pole: sztuki
**Koszyk** – zawiera kolekcję obiektów ProduktWKoszyku, implementuje interfejs Koszykable (metody ~~wloz~~ i ~~wyjmij~~), metoda wloz powinna rzucać wyjątek po przekroczeniu progu kwotowego dla Klienta
**Klient** – wymagane pola: identyfikator, Koszyk, budzet
**Sklep** – implementuje interfejs Sklepable (metody ~~zatowaruj~~, ~~wpuscKlientow~~, ~~kupowanie~~, ~~platnosc~~, ~~raportowanie~~) oraz zawiera pola: listaProduktow, klienci, kolejka

W osobnej klasie przeprowadź symulację:
Utwórz sklep.
Utwórz listę produktów i zatowaruj sklep.
Utwórz listę klientów i wpuść ich do sklepu.
Zasymuluj zakupy klientów w sklepie, kupują i dodają się do kolejki w sklepie.
Zasymuluj obsługę w kasie, klienci w kolejności z kolejki.
Podsumuj sesję zakupów, wyświetl raport.
