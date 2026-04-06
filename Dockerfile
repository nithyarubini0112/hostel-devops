FROM eclipse-temurin:17

WORKDIR /app

COPY app/ .

RUN javac Main.java

CMD ["java", "Main"]