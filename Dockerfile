FROM openjdk:11
COPY target/contact-regex-0.0.1-SNAPSHOT.jar contact-regex-0.0.1-SNAPSHOT.jar
ENTRYPOINT  ["java","-jar","contact-regex-0.0.1-SNAPSHOT.jar"]