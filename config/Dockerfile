FROM openjdk:11-jre-stretch
MAINTAINER Aydar Gumerbaev <aydar@gumerbaev.ru>

#RUN \
# apt update && apt upgrade -y && \
# apt install curl -y && \
# apt-get autoremove -y && apt-get clean && \
# rm -rf /var/cache/* && rm -rf /var/lib/apt/lists/*

ADD ./target/config.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/config.jar"]

HEALTHCHECK CMD curl -f http://localhost:8000/actuator/health || exit 1

EXPOSE 8000