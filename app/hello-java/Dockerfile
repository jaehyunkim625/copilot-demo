# FROM amazoncorretto:11 as TEMP_BUILD_IMAGE
FROM openjdk:11-jdk-slim as builder

# To solve ALAS2-2021-1693 vulnerabilities
# RUN yum update -y

# gradlew 빌드
COPY . .
WORKDIR /
RUN chmod +x ./gradlew
RUN ./gradlew bootjar

# Docker 이미지 실행 
FROM openjdk:11-jre-slim
COPY --from=builder build/libs/*.jar app.jar

# 컨테이너는 8080 포트로 실행된다 
EXPOSE 8080

ENTRYPOINT ["/bin/sh", "-c" , "exec java -Djava.security.egd=file:/dev/.urandom -Xmx1G -Xms512M -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/logs/ -Duser.timezone=Asia/Seoul -jar /app.jar"]