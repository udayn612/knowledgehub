FROM openjdk:11
ADD ./target/paragraph-tokenizer-0.0.1-SNAPSHOT.jar /usr/src/paragraph-tokenizer-0.0.1-SNAPSHOT.jar
EXPOSE 8090
WORKDIR usr/src
ENTRYPOINT ["java","-jar","paragraph-tokenizer-0.0.1-SNAPSHOT.jar"]
