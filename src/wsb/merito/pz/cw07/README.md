## **Temat: Strumieniowe przetwarzanie danych w Java Stream API**

### **1. Wprowadzenie do Stream API**
- Czym jest Stream API i dlaczego warto go używać?
- Różnice między kolekcjami a strumieniami
- Strumienie a iteracyjne przetwarzanie danych

### **2. Tworzenie strumieni**
- Ze zbiorów (`Collection.stream()`)
- Z tablic (`Arrays.stream()`)
- Z generatorów (`Stream.generate()`, `Stream.iterate()`)
- Z plików (`Files.lines()`)

### **3. Operacje pośrednie (Intermediate)**
- `map()` – transformacja elementów
- `filter()` – filtrowanie danych
- `distinct()` – usuwanie duplikatów
- `sorted()` – sortowanie
- `peek()` – podgląd elementów


### **4. Operacje terminalne (Terminal)**
- `collect()` – zbieranie wyników do kolekcji
- `count()` – liczba elementów
- `forEach()` – przetwarzanie każdego elementu
- `reduce()` – redukcja do jednej wartości
- `anyMatch()`, `allMatch()`, `noneMatch()` – sprawdzanie warunków


### **5. Grupowanie i partycjonowanie danych**
- `Collectors.groupingBy()`
- `Collectors.partitioningBy()`


### **6. Strumienie równoległe (Parallel Streams)**
- `parallelStream()` vs `stream()`
- Kiedy używać przetwarzania równoległego?

### **7. Przetwarzanie plików i danych wejściowych**
- Odczyt danych z pliku i filtrowanie zawartości
