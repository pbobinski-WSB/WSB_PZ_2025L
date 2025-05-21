class ConfigurationManager:
    _instance = None
    _initialized = False # Flaga do kontroli jednorazowej inicjalizacji __init__

    def __new__(cls, *args, **kwargs):
        if not cls._instance:
            cls._instance = super().__new__(cls)
            print("Singleton __new__: Tworzenie instancji ConfigurationManager")
        else:
            print("Singleton __new__: Zwracanie istniejącej instancji ConfigurationManager")
        return cls._instance

    def __init__(self, config_file="settings.ini"):
        # __init__ jest wywoływany za każdym razem, gdy próbujemy "stworzyć" obiekt,
        # nawet jeśli __new__ zwraca istniejącą instancję.
        # Dlatego potrzebujemy flagi _initialized, aby upewnić się,
        # że właściwa inicjalizacja (np. ładowanie pliku) dzieje się tylko raz.
        if not ConfigurationManager._initialized:
            print(f"Singleton __init__: Inicjalizacja ConfigurationManager (plik: {config_file})")
            self.settings = {}
            self._load_config(config_file)
            ConfigurationManager._initialized = True
        else:
            print("Singleton __init__: ConfigurationManager już zainicjalizowany, pomijam.")


    def _load_config(self, config_file):
        # W rzeczywistości tutaj ładowalibyśmy konfigurację z pliku
        print(f"Ładowanie konfiguracji z {config_file}...")
        self.settings["api_url"] = "http://example.com/api"
        self.settings["timeout"] = 30
        self.settings["debug_mode"] = False

    def get_setting(self, key):
        return self.settings.get(key)

    def set_setting(self, key, value):
        self.settings[key] = value
        print(f"Ustawiono '{key}' na '{value}'")

# --- Użycie ---
print("--- Pierwsze odwołanie ---")
config1 = ConfigurationManager("prod_settings.ini")
print(f"API URL (config1): {config1.get_setting('api_url')}")

print("\n--- Drugie odwołanie ---")
config2 = ConfigurationManager("dev_settings.ini") # Nazwa pliku zostanie zignorowana, bo __init__ nie wykona się ponownie
print(f"API URL (config2): {config2.get_setting('api_url')}")

print(f"\nCzy config1 to ten sam obiekt co config2? {config1 is config2}") # Powinno być True

config2.set_setting("debug_mode", True)
print(f"Debug Mode (config1): {config1.get_setting('debug_mode')}") # Powinno być True
print(f"Debug Mode (config2): {config2.get_setting('debug_mode')}") # Powinno być True

# Sprawdzenie czy __init__ wykonał się tylko raz
# (na podstawie _initialized i komunikatów z print)