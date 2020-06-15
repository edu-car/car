# How to test locally

```
docker build . -t edu-car
docker run edu-car
```

`sudo` may be needed in front of the `docker` command.

Gradle wrapper was removed so that there's a single place where Gradle version
is specified, that is: `Dockerfile`.

