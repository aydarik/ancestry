FROM openjdk:11-jre-slim
MAINTAINER Aydar Gumerbaev <aydar@gumerbaev.ru>

ADD ./target/account-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/account-service.jar"]

EXPOSE 6000