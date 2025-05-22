from abc import ABC, abstractmethod

class DataProcessor(ABC): # Klasa abstrakcyjna z metodą szablonową

    def process_data(self, filepath: str): # To jest metoda szablonowa
        """Definiuje szkielet algorytmu."""
        self.open_file(filepath)
        raw_data = self.read_data()
        processed_data = self.parse_data(raw_data) # Krok do nadpisania
        self.analyze_data(processed_data)         # Krok do nadpisania (opcjonalnie)
        self.close_file(filepath)
        print(f"--- Przetwarzanie pliku {filepath} zakończone ---\n")

    # Kroki konkretne, wspólne dla wszystkich podklas
    def open_file(self, filepath: str):
        print(f"Otwieranie pliku: {filepath}")
        # Symulacja otwarcia pliku
        self._file_content = f"Zawartość pliku {filepath}" 

    def read_data(self) -> str:
        print("Odczytywanie surowych danych...")
        # Symulacja odczytu
        return self._file_content 

    def close_file(self, filepath: str):
        print(f"Zamykanie pliku: {filepath}")

    # Kroki abstrakcyjne (lub "haki" - hook methods), które muszą zaimplementować podklasy
    @abstractmethod
    def parse_data(self, raw_data: str) -> any:
        """Przetwarza surowe dane na strukturę specyficzną dla formatu."""
        pass

    # Krok, który może być nadpisany (hook), ale ma domyślną implementację
    def analyze_data(self, parsed_data: any):
        print("Domyślna analiza danych: Brak szczegółowej analizy.")


# Konkretne implementacje dla różnych typów danych
class TextFileProcessor(DataProcessor):
    def parse_data(self, raw_data: str) -> list:
        print("Parsowanie pliku tekstowego: dzielenie na linie.")
        return raw_data.split('\n') # W naszym przykładzie to będzie jedna linia

    def analyze_data(self, parsed_data: list):
        print(f"Analiza pliku tekstowego: Znaleziono {len(parsed_data)} linii.")
        for i, line in enumerate(parsed_data):
            print(f"  Linia {i+1}: '{line}' (długość: {len(line)})")


class CsvFileProcessor(DataProcessor):
    def parse_data(self, raw_data: str) -> list:
        # Symulujemy, że plik CSV ma nagłówek i dane oddzielone przecinkami
        # W rzeczywistości surowe dane wyglądałyby inaczej, np. "name,age\nAlice,30\nBob,24"
        print("Parsowanie pliku CSV: dzielenie na wiersze i kolumny.")
        # Dla uproszczenia, załóżmy, że nasz 'raw_data' to jedna linia CSV
        # Prawdziwy plik CSV miałby wiele linii.
        # Symulacja: "dane1,dane2,dane3"
        simulated_csv_content = "nazwa_produktu,cena,ilosc\nKubek,15.99,100\nTalzerz,25.50,50"
        lines = simulated_csv_content.split('\n')
        header = lines[0].split(',')
        data_rows = [dict(zip(header, row.split(','))) for row in lines[1:]]
        return data_rows

    def analyze_data(self, parsed_data: list):
        print(f"Analiza pliku CSV: Znaleziono {len(parsed_data)} wierszy danych.")
        for row in parsed_data:
            print(f"  Produkt: {row.get('nazwa_produktu', 'N/A')}, Cena: {row.get('cena', 'N/A')}")


# --- Użycie ---
txt_processor = TextFileProcessor()
txt_processor.process_data("moj_dokument.txt")

csv_processor = CsvFileProcessor()
csv_processor.process_data("dane_sprzedazy.csv")