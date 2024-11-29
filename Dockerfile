# Use a imagem base do OpenJDK 17
FROM openjdk:17-jdk-slim

# Instala o Maven
RUN apt-get update && apt-get install -y maven

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo JAR gerado para o diretório de trabalho
COPY target/TalesEmissorMicroservico-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta que a aplicação irá rodar
EXPOSE 8083

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]