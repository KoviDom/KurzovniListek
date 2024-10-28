# Použij oficiální Java runtime obraz
FROM openjdk:17-jdk-slim

# Nastav pracovní adresář v kontejneru
WORKDIR /app

# Zkopíruj Maven Wrapper a zdrojový kód do kontejneru
COPY . .

# Zkompiluj projekt pomocí Maven Wrapperu
RUN ./mvnw clean package

# Nastav port, na kterém bude aplikace naslouchat
EXPOSE 8080

# Spusť aplikaci
CMD ["java", "-jar", "target/KurzovniListek-1.0.jar"]
