
${PACKETBEAT_HOME}/packetbeat -e -v -c ${PACKETBEAT_HOME}/packetbeat.yml

java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar