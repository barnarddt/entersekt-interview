FROM openjdk

# Install maven
RUN apt-get update
RUN apt-get install -y maven

WORKDIR /code

# Prepare by downloading dependencies
ADD pom.xml /code/pom.xml
RUN ["mvn", "dependency:resolve"]
RUN ["mvn", "verify"]


ADD src /code/src


RUN ["mvn", "package"]

EXPOSE 8080
# The dfault path plus java 8 so we don't get non matching java version errors
ENV PATH /usr/lib/jvm/java-8-openjdk-amd64/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin
CMD ["java", "-jar", "target/entersekt-interview-jar-with-dependencies.jar"]