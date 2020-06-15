FROM gradle:6.1-jdk11 as build

COPY --chown=gradle:gradle . /home/gradle/edu-car/car
WORKDIR /home/gradle/edu-car/car
RUN gradle installDist --no-daemon

FROM openjdk:11-jre

COPY --from=build /home/gradle/edu-car/car/build/install/educar /opt/edu-car

CMD /opt/edu-car/bin/educar
