from watchdog.observers import Observer
from watchdog.events import FileSystemEventHandler
import time

class MyHandler(FileSystemEventHandler):
    def on_modified(self, event):
        print(f"Zmodyfikowano: {event.src_path}")

    def on_created(self, event):
        print(f"Utworzono: {event.src_path}")

    def on_deleted(self, event):
        print(f"Usunięto: {event.src_path}")

if __name__ == "__main__":
    path = "../file/WatchedDir"
    event_handler = MyHandler()
    observer = Observer()
    observer.schedule(event_handler, path, recursive=False)
    observer.start()
    print("Nasłuchiwanie...")

    try:
        while True:
            time.sleep(1)
    except KeyboardInterrupt:
        observer.stop()
    observer.join()
