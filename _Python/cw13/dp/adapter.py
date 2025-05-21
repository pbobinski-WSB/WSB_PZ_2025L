# Adaptee (klasa, którą chcemy zaadaptować)
class LegacyLogger:
    def log_message(self, level: int, message: str):
        # Poziomy: 1 - INFO, 2 - WARNING, 3 - ERROR
        levels = {1: "INFO", 2: "WARNING", 3: "ERROR"}
        print(f"[Legacy] {levels.get(level, 'UNKNOWN')}: {message}")

# Target (interfejs, którego oczekuje klient)
# W Pythonie interfejsy są często nieformalne ("duck typing")
# ale dla jasności można zdefiniować klasę abstrakcyjną.
from abc import ABC, abstractmethod

class ModernLogger(ABC):
    @abstractmethod
    def info(self, message: str):
        pass

    @abstractmethod
    def warn(self, message: str):
        pass

    @abstractmethod
    def error(self, message: str):
        pass

# Adapter
class LoggerAdapter(ModernLogger):
    def __init__(self, legacy_logger: LegacyLogger):
        self._legacy_logger = legacy_logger

    def info(self, message: str):
        self._legacy_logger.log_message(1, message)

    def warn(self, message: str):
        self._legacy_logger.log_message(2, message)

    def error(self, message: str):
        self._legacy_logger.log_message(3, message)

# --- Klient (używa interfejsu ModernLogger) ---
def client_code(logger: ModernLogger, data_to_log: str):
    logger.info(f"Processing data: {data_to_log}")
    if len(data_to_log) < 5:
        logger.warn("Data is very short.")
    if "!" in data_to_log:
        logger.error("Critical symbol '!' found in data!")


# --- Użycie ---
legacy_log_instance = LegacyLogger()
adapter = LoggerAdapter(legacy_log_instance)

print("--- Użycie adaptera ---")
client_code(adapter, "Test data")
client_code(adapter, "Foo")
client_code(adapter, "Oh no!")

# Możemy też stworzyć "natywny" ModernLogger dla porównania
class ConsoleModernLogger(ModernLogger):
    def info(self, message: str):
        print(f"[Modern INFO] {message}")
    def warn(self, message: str):
        print(f"[Modern WARN] {message}")
    def error(self, message: str):
        print(f"[Modern ERROR] {message}")

print("\n--- Użycie natywnego nowoczesnego loggera ---")
modern_logger_instance = ConsoleModernLogger()
client_code(modern_logger_instance, "Another test")