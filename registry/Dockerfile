FROM openjdk:11-jre-slim
MAINTAINER Aydar Gumerbaev <aydar@gumerbaev.ru>

ADD ./target/registry.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/registry.jar"]

EXPOSE 3000