from pymongo import MongoClient


print("sync")

client = MongoClient("mongodb://localhost:27017")
db = client["sample_mflix"]
collection = db["movies"]

query = {"year": {"$gt": 2000}}
movies = collection.find(query, {"title": 1, "year": 1}).limit(10)  \

for movie in movies:
    print(movie)

client.close()

print("async")

import motor.motor_asyncio
import asyncio

client = motor.motor_asyncio.AsyncIOMotorClient("mongodb://localhost:27017")
db = client["sample_mflix"]
collection = db["movies"]

async def fetch_movies():
    query = {"year": {"$gt": 2000}}  
    cursor = collection.find(query, {"title": 1, "year": 1}).limit(10)   

    async for movie in cursor:
        print(movie)

asyncio.run(fetch_movies())

client.close()