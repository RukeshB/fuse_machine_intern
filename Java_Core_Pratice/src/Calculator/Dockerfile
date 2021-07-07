FROM openjdk:7
COPY . /fusemachine/basic
WORKDIR /fusemachine/basic
RUN javac Calculator_operation.java
RUN javac Application.java
CMD ["java","Application"]