#!/bin/sh

java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar &
${PACKETBEAT_HOME}/packetbeat -e -v -c ${PACKETBEAT_HOME}/packetbeat.yml &
${METRICBEAT_HOME}/metricbeat -e -v -c ${METRICBEAT_HOME}/metricbeat.yml

