# Real-Time Chat App with WebSocket + Kafka

A scalable, event-driven chat application built with Java and Spring Boot, leveraging WebSocket for real-time communication and Apache Kafka for distributed message streaming. Designed to demonstrate backend architecture patterns for high-throughput, low-latency systems.
---
## 🚀 Features
- Real-time messaging via WebSocket
- Kafka-based message streaming and decoupling
- MongoDB/Cassandra for persistent chat history
- REST API for retrieving historical messages
- Dockerized for easy deployment
- Optional JWT authentication and chat room support
---
## 🧱 Architecture Overview
Client (Browser/React)
⇅ WebSocket
Spring Boot Chat Service
⇅ Kafka (Producer/Consumer)
Kafka Broker Cluster
⇅
MongoDB/Cassandra (Chat History)
---
## ⚙️ Tech Stack

- **Java 17**
- **Spring Boot 3**
- **Apache Kafka**
- **MongoDB or Cassandra**
- **WebSocket (Spring WebSocket)**
- **Docker / Docker Compose**
- **Optional**: React frontend, JWT auth
---
## 📦 Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/mehar54/realtime-chat-kafka-websocket.git
cd realtime-chat-kafka-websocket
```
### 2. Start Kafka and MongoDB
```bash
docker-compose up -d
```
### 3. Run the Spring Boot App
```bash
./mvnw spring-boot:run
```
### 4. Connect WebSocket Client
```
Connect to: ws://localhost:8080/chat
Send JSON payload:
{
  "sender": "Mehar",
  "message": "Hello world!",
  "roomId": "general"
}
```
## API Endpoints
GET: /api/message/{roomId} -> Fetch chat history for a room
POST: /api/messages        -> Send message via REST