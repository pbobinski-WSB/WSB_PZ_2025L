import requests
import time

API_URL = "https://api.thecatapi.com/v1/images/search"

def fetch_cat():
    """Pobiera losowe zdjęcie kota z API."""
    response = requests.get(API_URL)
    if response.status_code == 200:
        return response.json()[0]["url"]
    return None

def main():
    start = time.time()
    
    cats = [fetch_cat() for _ in range(5)]  # Pobiera 5 zdjęć po kolei
    
    for i, cat in enumerate(cats, 1):
        print(f"{i}: {cat}")

    print(f"\nCzas wykonania: {time.time() - start:.2f} sekundy")

if __name__ == "__main__":
    main()
