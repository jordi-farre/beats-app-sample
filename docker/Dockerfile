FROM frolvlad/alpine-oraclejdk8:slim

ENV VERSION=1.1.2 PLATFORM=x86_64
ENV FILENAME=packetbeat-${VERSION}-${PLATFORM}.tar.gz
ENV PACKETBEAT_HOME /opt/packetbeat-${VERSION}-${PLATFORM}
ENV PATH $PATH:${PACKETBEAT_HOME}

VOLUME /tmp
ADD BeatsAppSample-1.0-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""

WORKDIR /opt/

RUN wget -q -O - http://download.elastic.co/beats/packetbeat/${FILENAME} | tar xz -C .

ADD packetbeat.yml ${PACKETBEAT_HOME}/
ADD docker-entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh

ENTRYPOINT ["/entrypoint.sh"]
