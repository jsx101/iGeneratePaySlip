FROM openjdk:16
COPY ./target/payslip-generator-docker.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch payslip-generator-docker.jar'
ENTRYPOINT ["java", "-jar", "payslip-generator-docker.jar"]