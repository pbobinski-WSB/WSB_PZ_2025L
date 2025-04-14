import socket

HOST = "127.0.0.1"
PORT = 12345

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server_socket:
    server_socket.bind((HOST, PORT))
    server_socket.listen()
    print("Serwer nasłuchuje na porcie", PORT)

    while True:
        conn, addr = server_socket.accept()
        with conn:
            print("Połączono z:", addr)
            while True:
                data = conn.recv(1024)
                if not data:
                    break
                print("Odebrano:", data.decode())
                conn.sendall(b"Echo: " + data)
