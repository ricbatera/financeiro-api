FROM openjdk

WORKDIR /app

ENV URL_DATABASE=jdbc:mysql://localhost:3307/financeiro
ENV USERNAME_DATABASE=root
ENV PASSWORD_DATABASE=178209

COPY target/financeiro-0.0.1-SNAPSHOT.jar /app/financeiro-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "financeiro-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=prod"]

EXPOSE 8080