
> 🔹 **TheCatAPI** (https://thecatapi.com/) udostępnia losowe zdjęcia kotów w JSON-ie. Możemy użyć endpointu:  
> `https://api.thecatapi.com/v1/images/search`

# **1. Synchroniczne pobieranie i przetwarzanie danych**
- Pobieramy **5 losowych zdjęć kotów**.
- Przetwarzamy dane za pomocą **Stream API**.
- Każde żądanie wykonuje się **kolejno**, co może być wolniejsze.

### **Co się dzieje w kodzie?**
✔ Pobieramy 5 razy dane **kolejno** za pomocą `HttpClient.send()`.  
✔ Przetwarzamy dane **strumieniowo** (`IntStream.range()`).  
✔ Prosta ekstrakcja URL-a zdjęcia z JSON-a.

### **Wady podejścia synchronicznego:**
**Wolniejsze**, bo każde żądanie czeka na zakończenie poprzedniego.  
Jeśli serwer odpowiada wolno, aplikacja się blokuje.

---
# **2. Asynchroniczne pobieranie i przetwarzanie danych**
- Pobieramy **5 zdjęć równolegle**.
- Korzystamy z **CompletableFuture** dla nieblokujących żądań.
- **Wszystkie zapytania wykonują się jednocześnie!**

### **Co robi ten kod?**
✔ Wysyła **5 zapytań jednocześnie**, zamiast po kolei.  
✔ Zwraca **CompletableFuture**, który przetwarza odpowiedź po jej otrzymaniu.  
✔ `CompletableFuture.allOf()` **czeka na wszystkie żądania**, zanim wypisze wyniki.

### **Zalety podejścia asynchronicznego:**
**Szybsze** – wszystkie zapytania wysyłane naraz!  
**Nie blokuje głównego wątku** – można robić inne rzeczy w tle.

