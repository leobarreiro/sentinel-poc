FROM eclipse-temurin:17.0.7_7-jre

RUN mkdir /opt/deployments

COPY @project.artifactId@-@project.version@.jar /opt/deployments/
COPY start.sh /opt/deployments/

RUN chmod 0755 /opt/deployments -R

ENTRYPOINT ["sh", "-c", "/opt/deployments/start.sh"]
