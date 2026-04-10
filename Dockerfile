FROM eclipse-temurin:17

WORKDIR /app

COPY app/ .

RUN javac *.java

CMD ["java", "Main"]