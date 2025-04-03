class Produkt:
    def __init__(self, nazwa, cena):
        self.nazwa = nazwa
        self.cena = cena

    def __str__(self):
        return f"{self.nazwa} - cena: {self.cena}"


class ProduktWkoszyku(Produkt):
    def __init__(self, nazwa, cena, ilosc_w_koszyku):
        super().__init__(nazwa, cena)
        self.ilosc_w_koszyku = ilosc_w_koszyku

    def __str__(self):
        return f"{self.nazwa} - cena: {self.cena}, ilość w koszyku: {self.ilosc_w_koszyku}"



class Klient:
    def __init__(self, imie, budzet):
        self.imie = imie
        self.budzet = budzet
        self.koszyk = Koszyk(self)

    def __str__(self):
        return f"Klient {self.imie} z budżetem {self.budzet} PLN"


class Koszyk:
    def __init__(self, klient):
        self.produkty = []
        self.klient = klient

    def dodaj_produkt(self, produkt, ilosc):
        koszt = produkt.cena * ilosc
        if self.klient.budzet >= koszt:
            produkt_w_koszyku = ProduktWkoszyku(produkt.nazwa, produkt.cena, ilosc)
            self.produkty.append(produkt_w_koszyku)
            self.klient.budzet -= koszt
        else:
            raise ValueError(f"Przekroczono budżet! {self.klient.imie} ma tylko {self.klient.budzet} PLN.")

    def __str__(self):
        if not self.produkty:
            return "Koszyk jest pusty."
        return "\n".join([str(produkt) for produkt in self.produkty])


class Sklep:
    _instance = None

    def __new__(cls):
        if cls._instance is None:
            cls._instance = super(Sklep, cls).__new__(cls)
            cls._instance.produkty = []
        return cls._instance

    def zatowaruj(self):
        self.produkty.append(Produkt("Chleb", 3.5))
        self.produkty.append(Produkt("Mleko", 2.5))
        self.produkty.append(Produkt("Ser", 5.0))

    def wpusc_klientow(self, klienci):
        for klient in klienci:
            print(f"Wpuszczono {klient}")

    def __str__(self):
        return "Produkty w sklepie:\n" + "\n".join([str(produkt) for produkt in self.produkty])
