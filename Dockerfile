FROM maven:3.6.1-jdk-14

COPY . snack.jar

ENTRYPOINT ["java", "-jar", "snack.jar"]