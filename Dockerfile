FROM openjdk:17-jdk-slim
COPY target/realtime-chat-kafka-websocket.jar chat-app.jar
ENTRYPOINT ["java", "-jar", "/chat-app.jar"]
