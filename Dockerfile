FROM oracle/openjdk

ADD . /app

RUN cd /app && ./gradlew build

EXPOSE 8080

CMD java -jar /app/build/libs/gol-spring-boot-0.0.1.jar
