# WebSocket Demo (Spring)

This project is a **simple demo** that shows how **two Spring applications communicate using raw WebSocket**.

- One application is a **WebSocket Server**
- The second application is a **WebSocket Client**
- They exchange simple text messages: **PING → PONG**

No STOMP, no message broker, no extra abstractions — just **plain WebSocket**.

---

## What This Demo Shows

1. The **server** starts and waits for WebSocket connections
2. The **client** connects to the server
3. When the connection is established:
   - the **client sends `PING`**
4. The **server receives `PING`** and replies with `PONG`
5. The **client receives `PONG`** and prints it to the console

---

## Project Structure

```
ws-app-server/    -> WebSocket server (Spring)
ws-app-client/    -> WebSocket client (Spring)
```

---

## Technologies Used

- Java
- Spring (WebSocket, MVC)
- Raw WebSocket (no STOMP)
- Gradle

---

## How to Run the Demo

### Step 1: Start the Server

1. Open a terminal and go to the server project:
```bash
cd ws-app-server
```

2. Make sure the server runs on port `1000`

`application.properties`:
```properties
server.port=1000
```

3. Start the server:
```bash
./gradlew bootRun
```

The server will now wait for WebSocket connections at:
```
ws://localhost:1000/ws
```

---

### Step 2: Start the Client

1. Open a second terminal and go to the client project:
```bash
cd ws-app-client
```

2. Start the client:
```bash
./gradlew bootRun
```

---

## What Happens Internally (Simple Explanation)

### Server Behavior
- Starts and waits for connections
- Receives messages from clients
- Responds with `PONG`
- Does not initiate messages on its own

### Client Behavior
- Starts and connects to the server
- Once connected, immediately sends `PING`
- Listens for messages from the server
- Prints responses to the console

---

## Expected Console Output

### Server Console
```
Server received a message: PING
```

### Client Console
```
Connection Established
PONG from server
```

---

## Communication Flow

```
Client  --->  PING  --->  Server
Client  <---  PONG  <---  Server
```

---

## Why Raw WebSocket (No STOMP)

- Lower latency
- Less overhead
- Easier client implementation
- Better for real-time control scenarios
- Ideal for device ↔ engine communication

---

## Important Notes

- The **client always initiates** the connection
- The **server only responds** to incoming messages
- Only one WebSocket connection is used
- Messages are plain text (JSON can be added easily)

---

## Summary

> Client connects → sends `PING` → server replies `PONG` → client receives response.

This is the most basic and clear example of WebSocket communication between two Spring applications.
