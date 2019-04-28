FROM openjdk:8

MAINTAINER kiralybianka1@gmail.com

COPY . /usr/src/JavaConsoleRPG

WORKDIR /usr/src/JavaConsoleRPG/src

RUN javac Main.java

CMD ["java", "Main"]
