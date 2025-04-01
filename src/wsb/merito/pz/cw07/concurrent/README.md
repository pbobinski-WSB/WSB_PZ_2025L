### **8. Operacje współbieżne i równoległe strumienie**
- Różnice między `stream()` a `parallelStream()`
- Problemy współbieżności w strumieniach
- Synchronizacja w równoległym przetwarzaniu

** Uwaga:** Operacje na zmiennych współdzielonych mogą prowadzić do błędów!

**Bezpieczne podejście (synchronizacja):**

### **9. Przetwarzanie HTTP synchronicznie i asynchronicznie**
- Użycie **`HttpClient`** do pobierania danych
- Przetwarzanie odpowiedzi w strumieniach
- **Asynchroniczne** pobieranie danych z użyciem `CompletableFuture`

**Synchroniczne pobieranie danych (blokujące):**

**Asynchroniczne pobieranie (bez blokowania):**

### **10. Asynchroniczne przetwarzanie wielu zapytań HTTP jednocześnie**
- `CompletableFuture.supplyAsync()`
- Kombinowanie wielu żądań

