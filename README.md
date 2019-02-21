[![Build Status](https://travis-ci.org/aydarik/ancestry.svg?branch=master)](https://travis-ci.org/aydarik/ancestry)

# Ancestry - Family Tree

Docker / Microservices test project.

### Built on

- Java
- Maven
- Spring Cloud
- PostgreSQL

### CI/CD workflow

- [Travis  CI](https://travis-ci.org/aydarik/ancestry)
- Docker Hub


### How to build

Gradle: `mvn clean package`

Docker: `docker-compose -f docker-compose.yml -f docker-compose.dev.yml build`

### How to start

Be sure, that you have exported environment variables:

```
export CONFIG_SERVICE_PASSWORD="1"
export ACCOUNT_SERVICE_PASSWORD="1"
export POSTGRESQL_PASSWORD="1"
```

> Instead of "**1**" it can be any password you want for each service.

##### Development

`docker-compose -f docker-compose.yml -f docker-compose.dev.yml up -d`

##### Production

`docker-compose up -d`

### How to use

Open http://localhost:80 in any browser.

### Important endpoints

- http://localhost:80 - Gateway
- http://localhost:8761 - Eureka Dashboard
