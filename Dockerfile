FROM eclipse-temurin
WORKDIR /opt/app
COPY build/libs/marketplace-1.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]