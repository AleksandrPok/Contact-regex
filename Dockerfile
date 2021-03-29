FROM openjdk:11-oracle
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /contact-regex-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-Dserver.port=8081", "-Dspring.datasource.url=jdbc:mysql://host.docker.internal:3306/contact_regex", "-jar", "contact-regex-0.0.1-SNAPSHOT.jar"]