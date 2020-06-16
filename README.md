# How to test locally

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

3. Open the browser and go to `http://1.2.3.4:8080/hello`.

## Note

Gradle wrapper was removed so that there's a single place where Gradle version
is specified, that is: `Dockerfile`.

