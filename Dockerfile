# Použij oficiální Java runtime obraz
FROM maven:3.8.7-eclipse-temurin-19

# Nastav pracovní adresář v kontejneru
WORKDIR /app

# Zkopíruj Maven Wrapper a zdrojový kód do kontejneru
COPY . .

# Zkompiluj projekt pomocí Maven Wrapperu
RUN mvn clean package

# Nastav port, na kterém bude aplikace naslouchat
EXPOSE 8080

# Spusť aplikaci
CMD ["java", "-jar", "target/KurzovniListek-1.0.jar"]
