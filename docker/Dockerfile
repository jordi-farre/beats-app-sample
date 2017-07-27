FROM frolvlad/alpine-oraclejdk8:slim

RUN apk add --update openssl

# Application setup
VOLUME /tmp
ADD BeatsAppSample-1.0-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""

WORKDIR /opt/

# Packetbeat setup
ENV PACKETBEAT_VERSION=5.5.1 PACKETBEAT_PLATFORM=linux-x86_64
ENV PACKETBEAT_FILENAME=packetbeat-${PACKETBEAT_VERSION}-${PACKETBEAT_PLATFORM}.tar.gz
ENV PACKETBEAT_HOME /opt/packetbeat-${PACKETBEAT_VERSION}-${PACKETBEAT_PLATFORM}
ENV PATH $PATH:${PACKETBEAT_HOME}
RUN wget -q -O - https://artifacts.elastic.co/downloads/beats/packetbeat/${PACKETBEAT_FILENAME} | tar xz -C .
ADD packetbeat.yml ${PACKETBEAT_HOME}/

# Metricbeat setup
ENV METRICBEAT_VERSION=5.5.1 METRICBEAT_PLATFORM=linux-x86_64
ENV METRICBEAT_FILENAME=metricbeat-${METRICBEAT_VERSION}-${METRICBEAT_PLATFORM}.tar.gz
ENV METRICBEAT_HOME /opt/metricbeat-${METRICBEAT_VERSION}-${METRICBEAT_PLATFORM}
ENV PATH $PATH:${METRICBEAT_HOME}
RUN wget -q -O - https://artifacts.elastic.co/downloads/beats/metricbeat/${METRICBEAT_FILENAME} | tar xz -C .
ADD metricbeat.yml ${METRICBEAT_HOME}/


# Entrypoint setup
ADD docker-entrypoint.sh /docker-entrypoint.sh
RUN chmod +x /docker-entrypoint.sh
ENTRYPOINT ["/docker-entrypoint.sh"]
