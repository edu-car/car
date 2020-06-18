# How to test locally

## With Docker

```
docker build . -t edu-car
docker -p 8081:8080 run edu-car
```

`sudo` may be needed in front of the `docker` command.

To call the service, open the console and make a POST request:

```
curl -d '{"turnedOn": true}' -H 'Content-Type: application/json' localhost:8081/setLedState
```

## With IDE or pure Java

To some extent, the service can be tested by just running the Java app. E.g. in IntelliJ,
a "play" button is displayed next to the `main` function. It's a convenient way to test some changes
without involving Docker.

## Note

Gradle wrapper was removed so that there's a single place where Gradle version
is specified, that is: `Dockerfile`.

