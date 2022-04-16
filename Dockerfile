#utiliza uma imagem do openjdk para ter um container que possua um executavel java

FROM openjdk
ADD target/ad_transport-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]