#!/bin/sh

echo "Redis Mode: $REDIS_MODE"

PROFILE="default"

if [ "$REDIS_MODE" = "sentinel" ]; then
    PROFILE="sentinel"
fi

echo "Profile utilizado $PROFILE"

$JAVA_HOME/bin/java \
    -Dfile.encoding="UTF-8" \
    -Xms256m \
    -Xmx512m \
    -Duser.timezone="America/Asuncion" \
    -Dhttps.protocols=TLSv1.2 \
    -jar "/opt/deployments/@project.artifactId@-@project.version@.jar" \
    --spring.profiles.active=$PROFILE
