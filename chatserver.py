from simple_websocket_server import WebSocketServer, WebSocket
import json

def get_message_content(message):
    try:
        msg_content = json.loads(message)
    except json.JSONDecodeError as e:
        print(f"Error parsing JSON: {e}")
        msg_content = {}
    return msg_content

def prepare_message(message_obj):
    msg_to_send = {}
    if message_obj.get('type') == 'login':
        msg_to_send['content'] = f"{message_obj.get('userName', 'Unknown user')} has been connected.\n"
    else:
        msg_to_send['content'] = f"{message_obj.get('userName', 'Unknown user')}: {message_obj.get('body', '')}.\n"
    return json.dumps(msg_to_send)

class ChatServer(WebSocket):
    clients = []

    @classmethod
    def broadcast_message(cls, message):
        for client in cls.clients:
            client.send_message(message)

    @classmethod
    def send_to_all_clients(cls, message):
        for client in cls.clients:
            client.send_message(message)

    def handle(self):
        print(f"Message Received: {self.data}")
        msg_content = get_message_content(self.data)
        message_to_send = prepare_message(msg_content)
        ChatServer.send_to_all_clients(message_to_send)

    def connected(self):
        ChatServer.clients.append(self)
        print(f"Number of Connected Clients: {len(ChatServer.clients)}")

    def handle_close(self):
        if self in ChatServer.clients:
            msg = {"content": f"{self.userName or 'Unknown user'} has been disconnected.\n"}
            ChatServer.clients.remove(self)
            msg_to_send = json.dumps(msg)
            ChatServer.send_to_all_clients(msg_to_send)
        else:
            print("Client not found in the clients list.")

if __name__ == "__main__":
    print("------> Server Starting <-------")
    server = WebSocketServer('', 8100, ChatServer)
    try:
        server.serve_forever()
    except KeyboardInterrupt:
        print("Server shutting down...")
        server.close()
