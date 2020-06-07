FROM openjdk:8u242

LABEL description="This text illustrates \
that label-values can span multiple lines."

RUN mkdir myvolume | cd myvolume | touch newFile

VOLUME /myvolume

EXPOSE 8080

ADD ./target/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]