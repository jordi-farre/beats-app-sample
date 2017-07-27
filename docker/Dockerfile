FROM frolvlad/alpine-oraclejdk8:slim

RUN apk add --update openssl

# Application setup
VOLUME /tmp
ADD BeatsAppSample-1.0-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""

# Packetbeat setup
ENV VERSION=5.5.1 PLATFORM=linux-x86_64
ENV FILENAME=packetbeat-${VERSION}-${PLATFORM}.tar.gz
ENV PACKETBEAT_HOME /opt/packetbeat-${VERSION}-${PLATFORM}
ENV PATH $PATH:${PACKETBEAT_HOME}
WORKDIR /opt/
RUN wget -q -O - https://artifacts.elastic.co/downloads/beats/packetbeat/${FILENAME} | tar xz -C .
ADD packetbeat.yml ${PACKETBEAT_HOME}/

# Entrypoint setup
ADD docker-entrypoint.sh /docker-entrypoint.sh
RUN chmod +x /docker-entrypoint.sh
ENTRYPOINT ["/docker-entrypoint.sh"]
