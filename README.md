# How to test locally

## With Docker

```
docker build . -t edu-car
docker run edu-car
```

`sudo` may be needed in front of the `docker` command.

To access the server:

1. Find out the container's ID by running `docker ps`. Let's say it's `foobar`

2. Find out the container's IP by calling
   ```
   docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' foobar
   ```
   Let's say it's 1.2.3.4.

3. Open the console and make a POST request:
   ```
   curl -d '{"turnedOn": true}' -H 'Content-Type: application/json' 1.2.3.4:8080/setLedState
   ```

## With IDE or pure Java

To some extent, the service can be tested by just running the Java app. E.g. in IntelliJ,
a "play" button is displayed next to the `main` function. It's a convenient way to test some changes
without involving Docker.

## Note

Gradle wrapper was removed so that there's a single place where Gradle version
is specified, that is: `Dockerfile`.

