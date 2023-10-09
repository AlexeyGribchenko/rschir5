FROM eclipse-temurin
WORKDIR /opt/app
COPY build/libs/marketplace-1.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]