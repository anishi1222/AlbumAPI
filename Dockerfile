ARG BUILD_IMAGE=maven:3.8.6-eclipse-temurin-17
ARG RUNTIME_IMAGE=mcr.microsoft.com/openjdk/jdk:17-cbld

# ---------------------------------------------------
# Resolve all maven dependencies
# ---------------------------------------------------
FROM ${BUILD_IMAGE} as dependencies

#ARG PROXY_SET=false
#ARG PROXY_HOST=
#ARG PROXY_PORT=

COPY pom.xml ./

RUN mvn -B dependency:go-offline
#        -DproxySet=${PROXY_SET} \
#        -DproxyHost=${PROXY_HOST} \
#        -DproxyPort=${PROXY_PORT} \


# ---------------------------------------------------
# Build an artifact
# ---------------------------------------------------
FROM dependencies as build

COPY src ./src

RUN mvn -B clean package
#        -DproxySet=${PROXY_SET} \
#        -DproxyHost=${PROXY_HOST} \
#        -DproxyPort=${PROXY_PORT} \

# ---------------------------------------------------
# Build container
# ---------------------------------------------------
FROM ${RUNTIME_IMAGE}

RUN mkdir /opt/app
COPY --from=build target/*.jar /opt/app/app.jar

EXPOSE 3500
ENTRYPOINT ["java","-jar", "/opt/app/app.jar"]