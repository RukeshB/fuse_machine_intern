FROM openjdk:7
COPY . /fusemachine/basic
WORKDIR /fusemachine/basic
RUN javac *.java
RUN java Application
CMD ["java","Application"]
