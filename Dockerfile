#FROM tomcat
#COPY . /app
#WORKDIR /app
#RUN ./mvnw package -DskipTests=true
#RUN cp ./target/*.war /usr/local/tomcat/webapps/
#CMD ["catalina.sh","run"]

FROM openjdk:jre-slim
RUN mkdir "skd"
COPY ./target/docker-demo.jar /skd
WORKDIR /skd
CMD ["java","-jar","docker-demo.jar"]