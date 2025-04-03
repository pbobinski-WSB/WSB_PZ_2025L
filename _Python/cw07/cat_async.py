import aiohttp
import asyncio
import time

API_URL = "https://api.thecatapi.com/v1/images/search"

async def fetch_cat(session):
    """Pobiera losowe zdjęcie kota asynchronicznie."""
    async with session.get(API_URL) as response:
        if response.status == 200:
            data = await response.json()
            return data[0]["url"]
    return None

async def main():
    start = time.time()
    
    async with aiohttp.ClientSession() as session:
        tasks = [fetch_cat(session) for _ in range(5)]  # Tworzymy zadania
        cats = await asyncio.gather(*tasks)  # Wykonujemy równocześnie
    
    for i, cat in enumerate(cats, 1):
        print(f"{i}: {cat}")

    print(f"\nCzas wykonania: {time.time() - start:.2f} sekundy")

if __name__ == "__main__":
    asyncio.run(main())
