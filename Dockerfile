# syntax=docker/dockerfile:experimental
FROM dsilvamarsh/ubuntu-jdk17:latest as build

#RUN apk upgrade --no-cache && \
#    apk add --no-cache openjdk17 \
#    apk add --no-cache make protobuf-dev
    
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN --mount=type=cache,target=/Users/dsilvamarsh/.m2/ ./mvnw install -DskipTests
#RUN mkdir -p target/dependency  
#RUN cd target/dependency
#RUN jar -xvf ../*.jar 

FROM alpine

RUN apk upgrade --no-cache && \
    apk add --no-cache openjdk17-jre-headless

RUN addgroup -S core-bank && adduser -S core-bank -G core-bank
USER core-bank
WORKDIR /app
ARG DEPENDENCY=/workspace/app/target
#COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
#COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
COPY --from=build  ${DEPENDENCY}/*.jar /app/com-bank-core-payments-iso-pain-008-001-10.jar

#ENTRYPOINT ["java","-cp","app:app/lib/*","com.bank.core.config.Application"]
ENTRYPOINT [ "java","-jar" ,"/app/com-bank-core-payments-iso-pain-008-001-10.jar"]